import { ITimeRate } from 'src/app/models/ITimeRate.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { RatesService } from 'src/app/services/rates.service';
import { LoginService } from 'src/app/services/login.service';

/**
 * Tabla para mostrar tarifas de tiempos
 */

@Component({
  selector: 'app-client-time',
  templateUrl: './client-time.component.html',
  styleUrls: ['./client-time.component.scss']
})
export class ClientTimeComponent implements OnInit {

  userNameId : string = '';
  displayedColumns: string[] = ['range', 'price'];
  timeRate : ITimeRate[] = [];
  dataSource = new MatTableDataSource(this.timeRate);

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private loginService : LoginService,
    private ratesService : RatesService
  ) { }

  ngOnInit(): void {
    this.userNameId = this.loginService.getUserName();

    this.ratesService.getTimeRates(this.userNameId)
    .subscribe({
      next: data => {
        this.timeRate = data
        this.dataSource.data = this.timeRate;
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
