import { Injectable, Injector } from '@angular/core';
import { IUserService } from './user.service-interface';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { BackendConfig, BackendType } from '../../config';
import { UserInMemoryService } from './user-in-memory.service';
import { UserRestService } from './user-rest.service';
import { UserResponse, UserFilter } from '../response-models/interfaces';

@Injectable()
export class UserService implements IUserService {

  private usedImplementation: IUserService;

  constructor(private injector: Injector, private http: HttpClient) {
    const backendConfig: BackendConfig = this.injector.get(BackendConfig);
    if (backendConfig.environmentType === BackendType.IN_MEMORY) {
      this.usedImplementation = new UserInMemoryService();
    } else { // default
      this.usedImplementation = new UserRestService(http);
    }
  }

  registerUser(userFilter: UserFilter): Observable<UserResponse> {
    return this.usedImplementation.registerUser(userFilter);
  }
}
