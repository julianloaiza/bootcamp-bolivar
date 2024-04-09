import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientCharacterComponent } from './client-character.component';

describe('ClientCharacterComponent', () => {
  let component: ClientCharacterComponent;
  let fixture: ComponentFixture<ClientCharacterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientCharacterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientCharacterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
