import { async, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CovalentLayoutModule } from '@covalent/core';

import { AccessService } from './access/shared/access.service';
import { AppComponent } from './app.component';
import { AuthService } from './shared/authentication/auth.service';
import { MaterialModule } from '@angular/material';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppComponent ],
      providers: [AccessService, AuthService],
      imports: [RouterTestingModule, CovalentLayoutModule, MaterialModule ],
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
});
