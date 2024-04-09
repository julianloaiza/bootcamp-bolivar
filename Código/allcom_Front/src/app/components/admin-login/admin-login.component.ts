import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

/**
 * Login para Admin
 */

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.scss']
})
export class AdminLoginComponent implements OnInit {

  form: FormGroup;
  @Output() logged = new EventEmitter();

  constructor(
    private formBuilder : FormBuilder,
    private snackBar: MatSnackBar,
    private loginService: LoginService,
    private router: Router
  ) {
    this.form = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  successLogin(userNameId : string) {
    console.log("Administrador ha iniciado sesión")
    this.loginService.setUserName(userNameId)
    this.logged.emit();
  }

  unsuccessLogin(msg : string) {
    this.snackBar.open(msg, '',{
      duration: 3000,
      horizontalPosition: "center",
      verticalPosition: "bottom"
    });
  }

  submitLogin() {

    this.loginService.getUser(this.form.value.username)
    .subscribe({ next : data => {
      if( data.password == this.form.value.password){
        if ( data.rolNameId == 'ADMIN') {
          this.successLogin(data.userNameId)
        }
        else {
          this.unsuccessLogin("El usuario no es un Administrador");
        }
      }
      else {
        this.unsuccessLogin("Contraseña Incorrecta");
      }
    }, error: msg => {
      console.log(msg);
      this.unsuccessLogin(msg);
    }})
  }

  return(){
    this.router.navigate(["iniciar-sesion"])
  }

}
