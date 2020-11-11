import { Injectable } from '@angular/core';
import {
  CanActivate,
  Router,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
} from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuardService implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
  ): boolean {
    console.log('activated');
    if (this.authService.isLogged() && this.authService.isPermited('VISITOR')) {
      // If its logged in and its role is visitor
      return true;
    }

    if (!this.authService.isLogged()) {
      // if its not logged in
      console.log('Error login');
    }

    if (this.router.url === '/') {
      // if the router is the app route
      this.router.navigate(['/login']);
    }
    return false;
  }
}
