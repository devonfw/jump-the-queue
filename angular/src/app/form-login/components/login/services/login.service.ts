import { map } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {
  Visitor,
  FilterVisitor,
  Pageable,
  VisitorArray,
} from 'src/app/shared/backendModels/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from 'src/app/core/authentication/auth.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private baseUrl = environment.baseUrlRestServices;
  constructor(
    private router: Router,
    private http: HttpClient,
    private authService: AuthService,
    public snackBar: MatSnackBar,
  ) {}

  authenticate(username: string, password: string): Observable<any> {
    let options: any;

    // CSRF
    if (environment.security === 'csrf') {
      options = {
        withCredentials: true,
        responseType: 'text',
        observe: 'response',
      };
    }

    // JWT
    if (environment.security === 'jwt') {
      options = { observe: 'response' };
    }

    return this.http.post(
      `${this.baseUrl}` + '/login',
      {
        username, password
      },
      options,
    );

  }

  getCsrf(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + '/csrf/v1/token', { withCredentials: true });
  }

  login(username: string, password: string): void {
    this.authenticate(username, password).subscribe(
      (res) => {
        // CSRF
        if (environment.security === 'csrf') {
          this.getCsrf().subscribe((data: any) => {
            this.authService.setToken(data.token);
            this.checkInUser(res, username);
          });
        }

        // JWT
        if (environment.security === 'jwt') {
          this.authService.setToken(res.headers.get('Authorization'));
          this.checkInUser(res, username);
        }
      },
      (err: any) => {
        this.snackBar.open('access error', 'OK', {
          duration: 2000,
        });
      },
    );

  }

  logout(): void {
    this.authService.setLogged(false);
    this.authService.setUser('');
    this.authService.setUserId(0);
    this.router.navigate(['FormLogin']);
  }

  checkInUser(userDetails, username): void {
    this.authService.setUserId(userDetails.id);
    this.authService.setLogged(true);
    this.authService.setUser(username);
    this.authService.setRole('VISITOR');
    this.router.navigate(['ViewQueue']);
  }
}
