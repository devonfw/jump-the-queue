import { Observable } from 'rxjs/Observable';
import { AccessCodeResponse, ExistingAccessCodeFilter } from '../response-models/interfaces';

export interface IAccessCodeService {

    /**
     * Confirms unvalidated user and creates an access code
     * Method: @GET
     */
    userConfirmation(token: string): Observable<AccessCodeResponse>;

    /**
     * Get Access Code by ID, usually used to update data information about this access code
     * Method: @GET
     */
    getAccessCode(codeId: number): Observable<AccessCodeResponse>;

    /**
     * Get which access code is attending actually by queue ID
     * Method: @GET
     */
    getAttendingAccessCodeByQueueId(queueId: number): Observable<AccessCodeResponse>;

    /**
     * Search existing Access Code to retrieve this data
     * Method: @POST
     */
    getExistingAccessCode(existingAccessCodeFilter: ExistingAccessCodeFilter): Observable<AccessCodeResponse>;
}
