import { Component, OnInit } from '@angular/core';
import { RequestsService } from 'src/app/services/requests.service';

import { IRequest } from 'src/app/models/IRequest.model';

/**
 * Grilla para las solicitudes
 */
@Component({
  selector: 'app-admin-requests',
  templateUrl: './admin-requests.component.html',
  styleUrls: ['./admin-requests.component.scss']
})
export class AdminRequestsComponent implements OnInit {

  requests : IRequest[] = [];

  constructor(
    private requestsService : RequestsService
  ) { }

  ngOnInit(): void {
    this.requestsService.getAll()
    .subscribe({
      next: data => {
      this.requests = data;
    }, error: msg => {
      console.log(msg);
    }})
  }

}
