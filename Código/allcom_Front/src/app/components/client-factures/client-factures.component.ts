import { Component, OnInit } from '@angular/core';
import { FacturesService } from 'src/app/services/factures.service';
import { LoginService } from 'src/app/services/login.service';
import { IFacture } from 'src/app/models/IFacture.model';

/**
 * Grilla responsive para mostrar facturas
 */
@Component({
  selector: 'app-client-factures',
  templateUrl: './client-factures.component.html',
  styleUrls: ['./client-factures.component.scss']
})
export class ClientFacturesComponent implements OnInit {

  userNameId : string = '';
  factures : IFacture[] = [];

  constructor(
    private facturesService : FacturesService,
    private loginService : LoginService
  ) {
  }

  ngOnInit(): void {
    this.userNameId = this.loginService.getUserName();
    this.facturesService.getByClient(this.userNameId)
    .subscribe({
      next: data => {
      this.factures = data.slice().reverse();
    }, error: msg => {
      console.log(msg);
    }});
  }

}
