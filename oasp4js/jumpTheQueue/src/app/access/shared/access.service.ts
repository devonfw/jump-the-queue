import { AuthService } from '../../shared/authentication/auth.service';

import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { MdSnackBar } from '@angular/material';
import { Router } from '@angular/router';
import { config } from '../../config';

@Injectable()
export class AccessService {

  constructor(private auth: AuthService,
              private http: Http,
              public snackBar: MdSnackBar,
              private router: Router) { }

  register(name, email, phone): void {
    this.http.post(`${config.basePath}visitormanagement/v1/register`, {name: name, email: email, phone: phone})
             .map(res => res.json())
             .subscribe( (res) => {
                this.auth.setLogged(true);
                this.auth.setUser(name);
                this.auth.setCode(res.code.code);
                this.router.navigate(['code']);
             }, (err) => {
                this.snackBar.open(err.json().message, 'OK', {
                  duration: 2000,
                });
             });
  }

  logoff(): void {
      this.auth.setLogged(false);
      this.auth.setUser('');
      this.auth.setCode('');
      this.router.navigate(['access']);
  }

}
