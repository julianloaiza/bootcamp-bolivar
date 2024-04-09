import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

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
