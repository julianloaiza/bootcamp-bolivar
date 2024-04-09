import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { IFacture } from 'src/app/models/IFacture.model';
import { FacturesService } from 'src/app/services/factures.service';

/**
 * Carga la tabla para mostrar las facturas de los clientes
 */
@Component({
  selector: 'app-admin-factures',
  templateUrl: './admin-factures.component.html',
  styleUrls: ['./admin-factures.component.scss']
})
export class AdminFacturesComponent implements OnInit {

  displayedColumns: string[] = ['dateReportId', 'userNameId', 'amount', 'factureId'];
  factures : IFacture[] = [];
  dataSource = new MatTableDataSource(this.factures);

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private facturesService : FacturesService
  ) { }

  ngOnInit(): void {
    this.facturesService.getAll()
    .subscribe({
      next: data => {
        this.factures = data;
        this.dataSource.data = this.factures;
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
