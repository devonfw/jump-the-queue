import { AuthService } from '../../shared/authentication/auth.service';

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { MdSnackBar } from '@angular/material';

@Injectable()
export class AccessService {

  constructor(private auth: AuthService,
              public snackBar: MdSnackBar,
              private router: Router) { }

  login(name, email, phone) {
    if (name === 'user' && email === 'asd@asd.com' && phone === 123456789) {
      this.auth.setLogged(true);
      this.auth.setUser(name);
      this.router.navigate(['code']);
    } else {
      this.snackBar.open('access error', 'OK', {
        duration: 2000,
      });
    }
  }

  logoff() {
      this.auth.setLogged(false);
      this.auth.setUser('');
      this.router.navigate(['access']);
  }

}
