import { Component, HostListener, OnInit } from '@angular/core';
import { Router } from '@angular/router';

/**
 * Login principal para elegir entre admin y cliente
 */
@Component({
  selector: 'app-home-login',
  templateUrl: './home-login.component.html',
  styleUrls: ['./home-login.component.scss']
})
export class HomeLoginComponent implements OnInit {

  constructor( private router: Router
    ) { }

    ngOnInit(): void {
    }

    adminLogin() {
      this.router.navigate(["administrador/reportes"])
    }

    clientLogin() {
      this.router.navigate(["cliente/facturas"])
    }
}
