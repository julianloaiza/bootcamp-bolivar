import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { IRequest, IRequestDTO } from '../models/IRequest.model';

/**
 * Servicio que se encarga de gestionar las solicitudes de revisión
 * Obtener todas las solicitudes de clientes
 * Obtener las solicitudes asociadas a un cliente
 * Crear una nueva solicitud de revisión
 */

@Injectable({
  providedIn: 'root'
})
export class RequestsService {

  private apiUrl : string = 'http://localhost:8080/allcom/api/solicitudes/';

  constructor(
    private http : HttpClient
  ) { }

  getAll() {
    return this.http.get<IRequest[]>( this.apiUrl)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El recurso no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }

  getByClient( userNameId : string) {
    return this.http.get<IRequest[]>( this.apiUrl + userNameId)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El recurso no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }

  post(requestDTO : IRequestDTO) {
    return this.http.post<IRequestDTO>(this.apiUrl, requestDTO)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.InternalServerError){
          return throwError(() => new Error('Hay un error interno del servidor'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }
}
