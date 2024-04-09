import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MaterialModule } from 'src/app/modules/material/material.module';

import { HomeComponent } from './home.component';
import { HomeLoginComponent } from 'src/app/components/home-login/home-login.component';

@NgModule({
  declarations: [
    HomeComponent,
    HomeLoginComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule
  ]
})
export class HomeModule { }
