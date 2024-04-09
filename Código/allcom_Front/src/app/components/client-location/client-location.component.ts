import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { RatesService } from 'src/app/services/rates.service';
import { LoginService } from 'src/app/services/login.service';
import { ILocationRate } from 'src/app/models/ILocationRate.model';

/**
 * Tabla para mostrar tarifas por ubicación
 */

@Component({
  selector: 'app-client-location',
  templateUrl: './client-location.component.html',
  styleUrls: ['./client-location.component.scss']
})
export class ClientLocationComponent implements OnInit {

  userNameId : string = '';
  displayedColumns: string[] = ['location', 'price'];
  locationRate : ILocationRate[] = [];
  dataSource = new MatTableDataSource(this.locationRate);

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private loginService : LoginService,
    private ratesService : RatesService
  ) { }

  ngOnInit(): void {
    this.userNameId = this.loginService.getUserName();

    this.ratesService.getLocationRates(this.userNameId)
    .subscribe({
      next: data => {
        this.locationRate = data
        this.dataSource.data = this.locationRate;
      }, error: msg => {
        console.log(msg);
    }})
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
