import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientChargesComponent } from './client-charges.component';

describe('ClientChargesComponent', () => {
  let component: ClientChargesComponent;
  let fixture: ComponentFixture<ClientChargesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientChargesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientChargesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
