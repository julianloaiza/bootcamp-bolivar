import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { IHourlyRate } from 'src/app/models/IHourlyRate.model';
import { RatesService } from 'src/app/services/rates.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-client-hourly',
  templateUrl: './client-hourly.component.html',
  styleUrls: ['./client-hourly.component.scss']
})
export class ClientHourlyComponent implements OnInit {

  userNameId : string = '';
  displayedColumns: string[] = ['range', 'price'];
  hourlyRate : IHourlyRate[] = [];
  dataSource = new MatTableDataSource(this.hourlyRate);

  /**
   * Tabla para mostrar tarifa por horarios
   */

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private loginService : LoginService,
    private ratesService : RatesService
  ) { }

  ngOnInit(): void {
    this.userNameId = this.loginService.getUserName();

    this.ratesService.getHourlyRates(this.userNameId)
    .subscribe({
      next: data => {
        this.hourlyRate = data
        this.dataSource.data = this.hourlyRate;
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
