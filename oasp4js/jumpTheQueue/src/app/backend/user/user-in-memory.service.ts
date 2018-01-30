import { Injectable } from '@angular/core';
import { IUserService } from './user.service-interface';
import { Observable } from 'rxjs/Observable';
import { user } from '../mock-data';
import 'rxjs/add/observable/of';
import { UserResponse, UserFilter } from '../response-models/interfaces';

@Injectable()
export class UserInMemoryService implements IUserService {

  constructor() { }

  registerUser(userFilter: UserFilter): Observable<UserResponse> {
    return Observable.of(user);
  }
}
