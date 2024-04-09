import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ICharacterRate } from 'src/app/models/ICharacterRate.model';
import { RatesService } from 'src/app/services/rates.service';
import { LoginService } from 'src/app/services/login.service';

/**
 * Tabla de tarifa para carecteres
 */
@Component({
  selector: 'app-client-character',
  templateUrl: './client-character.component.html',
  styleUrls: ['./client-character.component.scss']
})
export class ClientCharacterComponent implements OnInit {

  userNameId : string = '';
  displayedColumns: string[] = ['range', 'price'];
  charactersRate : ICharacterRate[] = [];
  dataSource = new MatTableDataSource(this.charactersRate);

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private loginService : LoginService,
    private ratesService : RatesService
  ) { }

  ngOnInit(): void {
    this.userNameId = this.loginService.getUserName();

    this.ratesService.getCharacterRates(this.userNameId)
    .subscribe({
      next: data => {
        this.charactersRate = data
        this.dataSource.data = this.charactersRate;
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
