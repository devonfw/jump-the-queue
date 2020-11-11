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

  getVisitorByUsername(username: string): Observable<Visitor> {
    const filters: FilterVisitor = new FilterVisitor();
    const pageable: Pageable = new Pageable();

    pageable.pageNumber = 0;
    pageable.pageSize = 1;
    pageable.sort = [];
    filters.username = username;
    filters.pageable = pageable;
    return this.http
      .post<VisitorArray>(
        `${this.baseUrl}` + '/visitormanagement/v1/visitor/search',
        filters,
      )
      .pipe(
        map((visitors) => {
          return visitors.content[0];
        }),
      );
  }

  login(username: string, password: string): void {
    // Checks if given username and password are the ones aved in the database
    console.log(password);
    this.getVisitorByUsername(username).subscribe(
      (visitorFound) => {
        if (
          visitorFound.username === username &&
          visitorFound.password === password
        ) {
          this.authService.setUserId(visitorFound.id);
          this.authService.setLogged(true);
          this.authService.setUser(visitorFound.username);
          visitorFound.userType = false;
          if (visitorFound.userType === false) {
            this.authService.setRole('VISITOR');
            this.router.navigate(['ViewQueue']);
          } else {
            this.authService.setLogged(false);
            this.snackBar.open('access error', 'OK', {
              duration: 2000,
            });
          }
        } else {
          this.snackBar.open('access error', 'OK', {
            duration: 2000,
          });
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
}
