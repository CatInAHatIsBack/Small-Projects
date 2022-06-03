import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrepBunnyEscapeComponent } from './prep-bunny-escape.component';

describe('PrepBunnyEscapeComponent', () => {
  let component: PrepBunnyEscapeComponent;
  let fixture: ComponentFixture<PrepBunnyEscapeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrepBunnyEscapeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrepBunnyEscapeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
