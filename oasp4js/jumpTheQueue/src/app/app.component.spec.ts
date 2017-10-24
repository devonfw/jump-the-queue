import { async, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { MatIconModule, MatSnackBarModule } from '@angular/material';
import { CovalentLayoutModule } from '@covalent/core';

import { AccessService } from './access/shared/access.service';
import { AuthService } from './shared/authentication/auth.service';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppComponent ],
      providers: [AccessService, AuthService],
      imports: [
        MatIconModule,
        MatSnackBarModule,
        RouterTestingModule,
        HttpClientModule,
        CovalentLayoutModule
      ],
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
});
