import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ILocation } from 'src/app/models/ILocation.model';
import { LocationsService } from 'src/app/services/locations.service';

/**
 * Vista de la tabla que muestra el reporte de las ubicaciones
 */

@Component({
  selector: 'app-admin-locations',
  templateUrl: './admin-locations.component.html',
  styleUrls: ['./admin-locations.component.scss']
})
export class AdminLocationsComponent implements OnInit {

  displayedColumns: string[] = ['dateReportId', 'locationName', 'amount', 'locationId'];
  locations : ILocation[] = [];
  dataSource = new MatTableDataSource(this.locations);

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  constructor(
    private locationsService : LocationsService
  ) { }

  ngOnInit(): void {
    this.locationsService.getAll()
    .subscribe({
      next: data => {
      this.locations = data;
      this.dataSource.data = this.locations;
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
