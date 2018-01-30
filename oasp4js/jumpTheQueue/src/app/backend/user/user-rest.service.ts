import { Injectable } from '@angular/core';
import { IUserService } from './user.service-interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserResponse, UserFilter } from '../response-models/interfaces';
import { environment } from '../../../environments/environment';

@Injectable()
export class UserRestService implements IUserService {

  constructor(private http: HttpClient) { }

  private readonly userAction: string = 'usermanagement/v1/user/';

  registerUser(userFilter: UserFilter): Observable<UserResponse> {
    return this.http.post<UserResponse>(`${environment.restServiceRoot}${this.userAction}`, userFilter);
  }
}
