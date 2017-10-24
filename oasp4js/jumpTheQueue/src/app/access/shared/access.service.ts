import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';
import { config } from '../../config';

import { AuthService } from '../../shared/authentication/auth.service';

@Injectable()
export class AccessService {

  constructor(private auth: AuthService,
              private http: HttpClient,
              public snackBar: MatSnackBar,
              private router: Router) { }

  register(name, email, phone): void {
    this.http.post<any>(`${config.basePath}visitormanagement/v1/register`, {name: name, email: email, phone: phone})
             .subscribe((res) => {
                this.auth.setLogged(true);
                this.auth.setUser(name);
                this.auth.setCode(res.code.code);
                this.router.navigate(['code']);
             }, (err) => {
                this.snackBar.open(err.error.message, 'OK', {
                  duration: 5000,
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
