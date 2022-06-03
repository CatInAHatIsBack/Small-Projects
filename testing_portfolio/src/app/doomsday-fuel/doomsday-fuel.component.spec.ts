import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoomsdayFuelComponent } from './doomsday-fuel.component';

describe('DoomsdayFuelComponent', () => {
  let component: DoomsdayFuelComponent;
  let fixture: ComponentFixture<DoomsdayFuelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoomsdayFuelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoomsdayFuelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
