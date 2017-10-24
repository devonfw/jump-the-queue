import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { MatCardModule } from '@angular/material';
import { CovalentLayoutModule } from '@covalent/core';

import { AuthService } from '../shared/authentication/auth.service';
import { CodeViewerComponent } from './code-viewer.component';

describe('CodeViewerComponent', () => {
  let component: CodeViewerComponent;
  let fixture: ComponentFixture<CodeViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CodeViewerComponent ],
      providers: [ AuthService ],
      imports: [
        BrowserAnimationsModule,
        MatCardModule,
        CovalentLayoutModule,
        RouterTestingModule,
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CodeViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
