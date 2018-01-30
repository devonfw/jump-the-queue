import { Observable } from 'rxjs/Observable';
import { TermsResponse } from '../response-models/interfaces';

export interface ITermsService {

    /**
     * Get terms by desired queue, by queue ID
     * Method: @GET
     */
    getTerms(queueId: number): Observable<TermsResponse>;

}
