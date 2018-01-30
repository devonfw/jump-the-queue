import { Injectable, Injector } from '@angular/core';
import { ITermsService } from './terms.service-interface';
import { HttpClient } from '@angular/common/http';
import { BackendConfig, BackendType } from '../../config';
import { TermsRestService } from './terms-rest.service';
import { TermsInMemoryService } from './terms-in-memory.service';
import { Observable } from 'rxjs/Observable';
import { TermsResponse } from '../response-models/interfaces';

@Injectable()
export class TermsService implements ITermsService {

  private usedImplementation: ITermsService;

  constructor(private injector: Injector, private http: HttpClient) {
    const backendConfig: BackendConfig = this.injector.get(BackendConfig);
    if (backendConfig.environmentType === BackendType.IN_MEMORY) {
      this.usedImplementation = new TermsInMemoryService();
    } else { // default
      this.usedImplementation = new TermsRestService(http);
    }
  }

  getTerms(queueId: number): Observable<TermsResponse> {
    return this.usedImplementation.getTerms(queueId);
  }
}
