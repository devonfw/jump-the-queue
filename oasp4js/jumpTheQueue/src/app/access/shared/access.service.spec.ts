import { AuthService } from '../../shared/authentication/auth.service';
import { AccessService } from './access.service';

import { inject, TestBed } from '@angular/core/testing';
import { MaterialModule, MdSnackBar } from '@angular/material';
import { RouterTestingModule } from '@angular/router/testing';


describe('AccessService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ AccessService, AuthService ],
      imports: [ RouterTestingModule, MaterialModule ]
    });
  });

  it('should ...', inject([AccessService], (service: AccessService) => {
    expect(service).toBeTruthy();
  }));
});
