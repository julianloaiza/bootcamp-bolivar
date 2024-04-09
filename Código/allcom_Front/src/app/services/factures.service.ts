import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { IFacture } from '../models/IFacture.model';

/**
 * Servicio que se encarga de obtener las facturas
 * todas, por id o por cliente, a través de peticiones Http
 */

@Injectable({
  providedIn: 'root'
})
export class FacturesService {

  private apiUrl = 'http://localhost:8080/allcom/api/facturas/';

  constructor(
    private http: HttpClient
  ) { }

  getAll(){
    return this.http.get<IFacture[]>(this.apiUrl)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El recurso no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }

  getById(factureId : number){
    return this.http.get<IFacture>(this.apiUrl + factureId)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El recurso no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }

  getByClient(userNameId : string){
    return this.http.get<IFacture[]>(this.apiUrl + 'cliente/' + userNameId)
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
