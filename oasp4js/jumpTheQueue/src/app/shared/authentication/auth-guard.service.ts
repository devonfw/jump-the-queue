import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService,
              private router: Router) {}

  canActivate(): boolean {

    if (this.authService.isLogged()) {
      return true;
    }

    if (this.router.url === '/') {
      this.router.navigate(['access']);
    }

    return false;
  }
}
