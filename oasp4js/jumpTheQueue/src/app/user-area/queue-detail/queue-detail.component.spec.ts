import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QueueDetailComponent } from './queue-detail.component';

describe('QueueDetailComponent', () => {
  let component: QueueDetailComponent;
  let fixture: ComponentFixture<QueueDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QueueDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QueueDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
