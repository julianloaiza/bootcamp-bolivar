import { Component, OnInit } from '@angular/core';
import { ReportsService } from 'src/app/services/reports.service';
import { MatSnackBar } from '@angular/material/snack-bar';

/**
 * Componente que muestra el front para llamar al procedimiento masivo
 */

@Component({
  selector: 'app-admin-charges',
  templateUrl: './admin-charges.component.html',
  styleUrls: ['./admin-charges.component.scss']
})
export class AdminChargesComponent implements OnInit {

  constructor(
    private reportsService : ReportsService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
  }

  success() {
    this.snackBar.open("Su solicitud ha sido enviada", '',{
      duration: 3000,
      horizontalPosition: "center",
      verticalPosition: "top"
    });
  }

  unsuccess( message : string) {
    this.snackBar.open(message, '',{
      duration: 3000,
      horizontalPosition: "center",
      verticalPosition: "top"
    });
  }

  generate() {

    this.reportsService.generate()
    .subscribe({
      error: errorMsg => {
        console.log(errorMsg);
        this.unsuccess(errorMsg);
    }, complete: () => {
        this.success();
    }});
  }

}
