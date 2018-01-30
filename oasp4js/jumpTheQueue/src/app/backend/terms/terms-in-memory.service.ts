import { Injectable } from '@angular/core';
import { ITermsService } from './terms.service-interface';
import { Observable } from 'rxjs/Observable';
import { terms } from '../mock-data';
import { TermsResponse } from '../response-models/interfaces';

@Injectable()
export class TermsInMemoryService implements ITermsService {

  constructor() { }

  getTerms(queueId: number): Observable<TermsResponse> {
    return Observable.of(terms);
  }
}
