import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerAreaComponent } from './owner-area.component';

describe('OwnerAreaComponent', () => {
  let component: OwnerAreaComponent;
  let fixture: ComponentFixture<OwnerAreaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerAreaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
