import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  active: boolean = false;

  constructor(
  ) {}

  ngOnInit(): void {
  }

  onLogged() {
    this.active = true;
  }
  offLogged() {
    this.active = false;
  }
}

