import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { IFacture } from 'src/app/models/IFacture.model';
import { IRequestDTO } from 'src/app/models/IRequest.model';
import { RequestsService } from 'src/app/services/requests.service';
import { MatSnackBar } from '@angular/material/snack-bar';

/**
 * Vista de una factura y enviar solicitud
 */
@Component({
  selector: 'app-client-facture',
  templateUrl: './client-facture.component.html',
  styleUrls: ['./client-facture.component.scss']
})
export class ClientFactureComponent implements OnInit {

  form: FormGroup;
  panelOpenState :boolean = false;

  @Input() facture: IFacture = {
    factureId: 0,
    userNameId: '',
    dateReportId: new Date,
    amount: 0
  }

  constructor(
    private formBuilder : FormBuilder,
    private requestService : RequestsService,
    private snackBar: MatSnackBar,
  ) {
    this.form = this.formBuilder.group({
      description: ['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  notify(msg : string) {
    this.snackBar.open(msg, '',{
      duration: 3000,
      horizontalPosition: "center",
      verticalPosition: "top"
    });
  }

  togglePanel() {

    this.panelOpenState = !this.panelOpenState;
    console.log(this.panelOpenState);
  }

  submitRequest() {
    const request : IRequestDTO = {
      userNameId: this.facture.userNameId,
      factureId: this.facture.factureId,
      state: 'T',
      description: this.form.value.description
    }
    this.requestService.post(request)
    .subscribe({
      next: data => {
        console.log('created', data);
        this.notify("Se ha enviado su solicitud");
        this.togglePanel();
        this.form.reset();
      }, error: msg => {
        console.log(msg);
        this.notify(msg)
      }})
  }
}
