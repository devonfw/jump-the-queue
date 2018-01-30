import { Observable } from 'rxjs/Observable';
import { UserResponse, UserFilter } from '../response-models/interfaces';

export interface IUserService {

    /**
     * Register new user not validated
     * Method: @POST
     */
    registerUser(userFilter: UserFilter): Observable<UserResponse>;

}
