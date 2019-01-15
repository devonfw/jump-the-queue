import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewQueueComponent } from './view-queue.component';

describe('ViewQueueComponent', () => {
  let component: ViewQueueComponent;
  let fixture: ComponentFixture<ViewQueueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewQueueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewQueueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
