import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';

import { environment } from 'src/environments/environment';
import { AuthService } from '../core/authentication/auth.service';

@Injectable()
export class HttpRequestInterceptorService implements HttpInterceptor {
  constructor(private auth: AuthService) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler,
  ): Observable<HttpEvent<any>> {
    // Get the auth header from the service.
    const authHeader: string = this.auth.getToken();
    if (authHeader) {
      let authReq: HttpRequest<any>;

      // CSRF
      if (environment.security === 'csrf') {
        authReq = req.clone({
          withCredentials: true,
          setHeaders: { 'X-CSRF-TOKEN': authHeader },
        });
      }

      // JWT
      if (environment.security === 'jwt') {
        authReq = req.clone({
          setHeaders: { authorization: authHeader },
        });
      }

      return next.handle(authReq);
    } else {
      return next.handle(req);
    }
  }
}
