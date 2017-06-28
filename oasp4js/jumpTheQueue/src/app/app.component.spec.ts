import { async, TestBed } from '@angular/core/testing';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';
import { RouterTestingModule } from '@angular/router/testing';
import { CovalentLayoutModule } from '@covalent/core';

import { AccessService } from './access/shared/access.service';
import { AuthService } from './shared/authentication/auth.service';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppComponent ],
      providers: [AccessService, AuthService],
      imports: [RouterTestingModule, HttpModule, CovalentLayoutModule, MaterialModule ],
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
});
