import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { RequestsService } from 'src/app/services/requests.service';

import { IRequest } from 'src/app/models/IRequest.model';

/**
 * Grilla para mostrar solicitudes
 */

@Component({
  selector: 'app-client-requests',
  templateUrl: './client-requests.component.html',
  styleUrls: ['./client-requests.component.scss']
})
export class ClientRequestsComponent implements OnInit {

  userNameId : string = '';
  requests : IRequest[] = [];

  constructor(
    private loginService : LoginService,
    private requestsService : RequestsService
  ) { }

  ngOnInit(): void {
    this.userNameId = this.loginService.getUserName();
    this.requestsService.getByClient(this.userNameId)
    .subscribe({
      next : data => {
      this.requests = data;
    }, error: msg => {
      console.log(msg);
    }})
  }

}
