import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExistCodeComponent } from './exist-code.component';

describe('ExistCodeComponent', () => {
  let component: ExistCodeComponent;
  let fixture: ComponentFixture<ExistCodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExistCodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExistCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
