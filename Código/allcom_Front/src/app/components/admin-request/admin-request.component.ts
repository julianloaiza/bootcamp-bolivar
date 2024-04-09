import { Component, Input, OnInit } from '@angular/core';
import { IRequest } from 'src/app/models/IRequest.model';
import { IFacture } from 'src/app/models/IFacture.model';
import { FacturesService } from 'src/app/services/factures.service';
import { RequestsService } from 'src/app/services/requests.service';
import { MatSnackBar } from '@angular/material/snack-bar';

/**
 * Vista de una solicitud
 */
@Component({
  selector: 'app-admin-request',
  templateUrl: './admin-request.component.html',
  styleUrls: ['./admin-request.component.scss']
})
export class AdminRequestComponent implements OnInit {

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
    private facturesService : FacturesService,
    private requestsService : RequestsService,
    private snackBar : MatSnackBar
  ) { }


  ngOnInit(): void {
    this.facturesService.getById(this.request.factureId)
    .subscribe({
      next: data => {
        this.facture = data;
    }, error: msg => {
      console.log(msg);
    }})

    this.changeColor(this.request.state);
  }

  changeColor(state : string){
    if (this.request.state == 'T') {
      this.color_state = "warn"
    }
    else {
      this.color_state = "primary"
    }
  }

  notify(msg : string) {
    this.snackBar.open(msg, '',{
      duration: 3000,
      horizontalPosition: "center",
      verticalPosition: "top"
    });
  }

  sendRequest(state : string){
    this.request.state = state;
    this.requestsService.post(this.request).subscribe({
    next: data => {
        console.log('created', data);
        this.notify("Se ha cerrado la solicitud");
        this.changeColor(this.request.state);
      }, error: msg => {
        console.log(msg);
        this.notify(msg)
      }})

  }

}
