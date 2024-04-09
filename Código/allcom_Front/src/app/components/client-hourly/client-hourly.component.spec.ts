import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientHourlyComponent } from './client-hourly.component';

describe('ClientHourlyComponent', () => {
  let component: ClientHourlyComponent;
  let fixture: ComponentFixture<ClientHourlyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientHourlyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientHourlyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
