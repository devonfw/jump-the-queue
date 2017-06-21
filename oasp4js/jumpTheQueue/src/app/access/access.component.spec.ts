import { AuthService } from '../shared/authentication/auth.service';
import { AccessComponent } from './access.component';
import { AccessService } from './shared/access.service';

import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterTestingModule } from '@angular/router/testing';
import { CovalentLayoutModule } from '@covalent/core';

describe('AccessComponent', () => {
  let component: AccessComponent;
  let fixture: ComponentFixture<AccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccessComponent ],
      providers: [ AccessService, AuthService ],
      imports: [ BrowserAnimationsModule, MaterialModule, FormsModule, CovalentLayoutModule, RouterTestingModule ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
