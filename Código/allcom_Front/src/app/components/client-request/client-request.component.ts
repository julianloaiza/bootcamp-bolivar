import { Component, Input, OnInit } from '@angular/core';
import { IRequest } from 'src/app/models/IRequest.model';
import { IFacture } from 'src/app/models/IFacture.model';
import { FacturesService } from 'src/app/services/factures.service';

/**
 * Vista de una solicitud del cliente
 */
@Component({
  selector: 'app-client-request',
  templateUrl: './client-request.component.html',
  styleUrls: ['./client-request.component.scss']
})
export class ClientRequestComponent implements OnInit {

  color_state : string = '';

  @Input() request : IRequest = {
    requestId: 0,
    userNameId: '',
    factureId: 0,
    state: '',
    description: ''
  };

  facture : IFacture = {
    factureId: 0,
    userNameId: '',
    dateReportId: new Date,
    amount: 0
  };

  constructor(
    private facturesService : FacturesService
  ) { }

  changeColor(state : string){
    if (this.request.state == 'T') {
      this.color_state = "warn"
    }
    else {
      this.color_state = "primary"
    }
  }

  ngOnInit(): void {
    this.facturesService.getById(this.request.factureId)
    .subscribe({
      next: data => {
        this.facture = data;
    }, error: msg => {
      console.log(msg);
    }});

    this.changeColor(this.request.state);
  }

}
