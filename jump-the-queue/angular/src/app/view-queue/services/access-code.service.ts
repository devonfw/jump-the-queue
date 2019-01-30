import { Injectable } from '@angular/core';
import { AuthService } from 'src/app/core/authentication/auth.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AccessCode, Pageable, FilterAccessCode } from 'src/app/shared/backendModels/interfaces';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { map, filter } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AccessCodeService {

  private baseUrl = environment.baseUrlRestServices;

  constructor(private router: Router, private http: HttpClient, private authService: AuthService) { }

  getCurrentlyAttendedAccessCode(): Observable<AccessCode> {
    const filters: FilterAccessCode = new FilterAccessCode();
    const pageable: Pageable = new Pageable();

    pageable.pageNumber = 0;
    pageable.pageSize = 1;
    filters.pageable = pageable;
    return this.http.post<AccessCode>(`${this.baseUrl}` + '/accesscodemanagement/v1/accesscode/cto/search', filters)
    .pipe(
        map(accesscodes => {
          if (!accesscodes['content'][0]) {
            throw new Error('Value expected!');
          }
          return accesscodes['content'][0]['accessCode'];
        }),
     );
  }

  getVisitorAccessCode(visitorId: number): Observable<AccessCode> {
    const filters: FilterAccessCode = new FilterAccessCode();
    const pageable: Pageable = new Pageable();

    pageable.pageNumber = 0;
    pageable.pageSize = 1;
    filters.visitorId = visitorId;
    filters.pageable = pageable;
    return this.http.post<AccessCode>(`${this.baseUrl}` + '/accesscodemanagement/v1/accesscode/cto/search', filters)
    .pipe(
      map(accesscodes => {
        if (accesscodes['content'][0]) {
          return accesscodes['content'][0]['accessCode'];
        } else {
          return null;
        }
      }),
     );
  }

  deleteAccessCode(codeAccessId: number) {
    this.http.delete<AccessCode>(`${this.baseUrl}` + '/accesscodemanagement/v1/accesscode/' + codeAccessId + '/').subscribe();
  }

  saveAccessCode(visitorId: number, queueId: number) {
    const accessCode: AccessCode = new AccessCode();
    accessCode.visitorId = visitorId;
    accessCode.queueId = queueId;
    return this.http.post<AccessCode>(`${this.baseUrl}` + '/accesscodemanagement/v1/accesscode/', accessCode);
  }
}
