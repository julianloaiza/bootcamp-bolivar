import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MaterialModule } from 'src/app/modules/material/material.module';

import { ClientComponent } from './client.component';
import { ClientHeaderComponent } from 'src/app/components/client-header/client-header.component';
import { ClientLoginComponent } from 'src/app/components/client-login/client-login.component';
import { ClientFacturesComponent } from 'src/app/components/client-factures/client-factures.component';
import { ClientRequestsComponent } from 'src/app/components/client-requests/client-requests.component';
import { ClientChargesComponent } from 'src/app/components/client-charges/client-charges.component';

import { ClientFactureComponent } from 'src/app/components/client-facture/client-facture.component';
import { ClientRequestComponent } from 'src/app/components/client-request/client-request.component';
import { ClientCharacterComponent } from 'src/app/components/client-character/client-character.component';
import { ClientHourlyComponent } from 'src/app/components/client-hourly/client-hourly.component';
import { ClientTimeComponent } from 'src/app/components/client-time/client-time.component';
import { ClientLocationComponent } from 'src/app/components/client-location/client-location.component';

@NgModule({
  declarations: [
    ClientComponent,
    ClientHeaderComponent,
    ClientLoginComponent,
    ClientFacturesComponent,
    ClientRequestsComponent,
    ClientChargesComponent,
    ClientFactureComponent,
    ClientRequestComponent,
    ClientCharacterComponent,
    ClientHourlyComponent,
    ClientTimeComponent,
    ClientLocationComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule
  ]
})
export class ClientModule { }
