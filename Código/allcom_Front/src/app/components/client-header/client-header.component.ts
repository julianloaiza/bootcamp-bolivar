import { Component, OnInit, Output, EventEmitter} from '@angular/core';

/**
 * Navbar para clientes
 */
@Component({
  selector: 'app-client-header',
  templateUrl: './client-header.component.html',
  styleUrls: ['./client-header.component.scss']
})
export class ClientHeaderComponent implements OnInit {

  @Output() unlogged = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  return() {
    this.unlogged.emit()
  }

}
