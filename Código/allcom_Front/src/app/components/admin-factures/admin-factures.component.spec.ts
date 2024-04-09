import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFacturesComponent } from './admin-factures.component';

describe('AdminFacturesComponent', () => {
  let component: AdminFacturesComponent;
  let fixture: ComponentFixture<AdminFacturesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminFacturesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminFacturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
