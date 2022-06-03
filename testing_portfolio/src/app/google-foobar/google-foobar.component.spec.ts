import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoogleFoobarComponent } from './google-foobar.component';

describe('GoogleFoobarComponent', () => {
  let component: GoogleFoobarComponent;
  let fixture: ComponentFixture<GoogleFoobarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GoogleFoobarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GoogleFoobarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
