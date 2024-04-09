import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';

/**
 * Servicio que se encarga de ejecutar el proceso masivo
 * Generar facturas y reportes de forma manual
 */

@Injectable({
  providedIn: 'root'
})
export class ReportsService {

  private apiUrl = 'http://localhost:8080/allcom/api/reportes';

  constructor(
    private http: HttpClient
  ) { }

  generate() {
    return this.http.get( this.apiUrl + '/generar')
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
