import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MaterialModule } from 'src/app/modules/material/material.module';

import { AdminComponent } from './admin.component';
import { AdminHeaderComponent } from 'src/app/components/admin-header/admin-header.component';
import { AdminLoginComponent } from 'src/app/components/admin-login/admin-login.component';
import { AdminReportsComponent } from 'src/app/components/admin-reports/admin-reports.component';
import { AdminRequestsComponent } from 'src/app/components/admin-requests/admin-requests.component';
import { AdminChargesComponent } from 'src/app/components/admin-charges/admin-charges.component';
import { AdminRequestComponent } from 'src/app/components/admin-request/admin-request.component';
import { AdminFacturesComponent } from 'src/app/components/admin-factures/admin-factures.component';
import { AdminLocationsComponent } from 'src/app/components/admin-locations/admin-locations.component';
@NgModule({
  declarations: [
    AdminComponent,
    AdminHeaderComponent,
    AdminLoginComponent,
    AdminReportsComponent,
    AdminRequestsComponent,
    AdminChargesComponent,
    AdminRequestComponent,
    AdminFacturesComponent,
    AdminLocationsComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule
  ]
})
export class AdminModule { }
