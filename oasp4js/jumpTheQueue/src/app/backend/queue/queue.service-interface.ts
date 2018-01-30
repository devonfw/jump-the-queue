import { Observable } from 'rxjs/Observable';
import { AccessCodeResponse } from '../response-models/interfaces';

export interface IQueueService {

  /**
   * Attend a new access code after the current attended access code
   * Method: @PUT
   */
  attendAccessCode(queueId: number): Observable<AccessCodeResponse>;

}
