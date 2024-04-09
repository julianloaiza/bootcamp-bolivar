import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { catchError, throwError } from 'rxjs';
import { IUser } from '../models/IUser.model';

/**
 * Servicio que se encarga de traer a un usuario a través de peticiones Http
 * Identifica qué usuario está logeado a través del atributo userNameId
 */

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = 'http://localhost:8080/allcom/api/usuarios/';
  private userNameId = '';

  constructor(
    private http: HttpClient
  ) { }

  getUser( userNameId : string) {
    return this.http.get<IUser>(this.apiUrl + userNameId)
    .pipe(
      catchError((error : HttpErrorResponse) => {
        if(error.status == HttpStatusCode.NotFound){
          return throwError(() => new Error('El usuario no existe'));
        }
        return throwError(() => new Error('Ha ocurrido un error inesperado'));
      })
    )
  }

  setUserName(userNameId : string){
    this.userNameId = userNameId;
  }

  getUserName(): string {
    return this.userNameId;
  }
}
