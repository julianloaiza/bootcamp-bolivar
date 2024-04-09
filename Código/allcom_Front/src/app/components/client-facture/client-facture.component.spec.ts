import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientFactureComponent } from './client-facture.component';

describe('ClientFactureComponent', () => {
  let component: ClientFactureComponent;
  let fixture: ComponentFixture<ClientFactureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientFactureComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientFactureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
