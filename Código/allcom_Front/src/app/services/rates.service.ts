import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { IHourlyRate } from '../models/IHourlyRate.model';
import { ICharacterRate } from '../models/ICharacterRate.model';
import { ITimeRate } from '../models/ITimeRate.model';
import { ILocationRate } from '../models/ILocationRate.model';

/**
 * Servicio que se encarga de traer las tarifas acordadas para un cliente
 * Según un rango Horario, rango de tiempo, rango de caracteres y ubicación
 */

@Injectable({
  providedIn: 'root'
})
export class RatesService {

  private apiUrl = 'http://localhost:8080/allcom/api/';

  constructor(
    private http: HttpClient
  ) { }

  getHourlyRates(userNameId : string){
    return this.http.get<IHourlyRate[]>(this.apiUrl + 'tarifahorarios/' + userNameId)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El recurso no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }

  getCharacterRates(userNameId : string){
    return this.http.get<ICharacterRate[]>(this.apiUrl + 'tarifacaracteres/' + userNameId)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El recurso no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }

  getTimeRates(userNameId : string){
    return this.http.get<ITimeRate[]>(this.apiUrl + 'tarifatiempos/' + userNameId)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El recurso no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }

  getLocationRates(userNameId : string){
    return this.http.get<ILocationRate[]>(this.apiUrl + 'tarifaubicaciones/' + userNameId)
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
