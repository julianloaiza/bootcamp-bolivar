import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { ILocation } from '../models/ILocation.model';

/**
 * Servicio que se encarga de obtener los reportes por ubicación
 */
@Injectable({
  providedIn: 'root'
})
export class LocationsService {

  private apiUrl = 'http://localhost:8080/allcom/api/ubicaciones/';

  constructor(
    private http : HttpClient
  ) { }

  getAll(){
    return this.http.get<ILocation[]>(this.apiUrl)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El recurso no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }
}
