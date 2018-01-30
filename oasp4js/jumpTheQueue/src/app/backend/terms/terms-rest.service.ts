import { Injectable } from '@angular/core';
import { ITermsService } from './terms.service-interface';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { TermsResponse } from '../response-models/interfaces';
import { environment } from '../../../environments/environment';

@Injectable()
export class TermsRestService implements ITermsService {

  private readonly getTermsAction: string = 'termsmanagement/v1/terms/queue/';

  constructor(private http: HttpClient) { }

  getTerms(queueId: number): Observable<TermsResponse> {
    return this.http.get<TermsResponse>(`${environment.restServiceRoot}${this.getTermsAction}` + queueId);
  }

}
