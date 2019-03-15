import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckerSearchComponent } from './checker-search.component';

describe('CheckerSearchComponent', () => {
  let component: CheckerSearchComponent;
  let fixture: ComponentFixture<CheckerSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckerSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckerSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
