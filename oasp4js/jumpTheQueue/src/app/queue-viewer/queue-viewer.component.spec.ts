import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { MatCardModule } from '@angular/material';
import { CovalentDataTableModule, CovalentLayoutModule } from '@covalent/core';

import { AuthService } from '../shared/authentication/auth.service';
import { QueueViewerComponent } from './queue-viewer.component';
import { QueueViewerService } from './shared/queue-viewer.service';

describe('QueueViewerComponent', () => {
  let component: QueueViewerComponent;
  let fixture: ComponentFixture<QueueViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QueueViewerComponent ],
      providers: [ QueueViewerService, AuthService ],
      imports: [
        BrowserAnimationsModule,
        HttpClientModule,
        MatCardModule,
        CovalentLayoutModule,
        CovalentDataTableModule,
        RouterTestingModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QueueViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
