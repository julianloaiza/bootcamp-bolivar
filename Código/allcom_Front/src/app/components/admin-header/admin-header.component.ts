import { Component, OnInit, Output, EventEmitter} from '@angular/core';

/**
 * Navbar responsive para el admin
 */
@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.scss']
})
export class AdminHeaderComponent implements OnInit {

  @Output() unlogged = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  return () {
    this.unlogged.emit()
  }
}
