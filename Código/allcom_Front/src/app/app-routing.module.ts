import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeLoginComponent } from './components/home-login/home-login.component';
import { HomeComponent } from './layouts/home/home.component';
import { AdminComponent } from './layouts/admin/admin.component';
import { AdminReportsComponent } from './components/admin-reports/admin-reports.component';
import { AdminRequestsComponent } from './components/admin-requests/admin-requests.component';
import { AdminChargesComponent } from './components/admin-charges/admin-charges.component';
import { ClientComponent } from './layouts/client/client.component';
import { ClientFacturesComponent } from './components/client-factures/client-factures.component';
import { ClientRequestsComponent } from './components/client-requests/client-requests.component';
import { ClientChargesComponent } from './components/client-charges/client-charges.component';

const routes: Routes = [
  {
    path: "", component: HomeComponent,
    children: [
      {
        path: "iniciar-sesion", component: HomeLoginComponent
      }
    ]
  },
  {
    path: "administrador", component: AdminComponent,
    children: [
      {
        path: "reportes", component: AdminReportsComponent
      },
      {
        path: "solicitudes", component: AdminRequestsComponent
      },
      {
        path: "cobros", component: AdminChargesComponent
      }
    ]
  },
  {
    path: "cliente", component: ClientComponent,
    children: [
      {
        path: "facturas", component: ClientFacturesComponent
      },
      {
        path: "solicitudes", component: ClientRequestsComponent
      },
      {
        path: "tarifas", component: ClientChargesComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
