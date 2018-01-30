import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { IAccessCodeService } from './accesscode.service-interface';
import { AccesscodeInMemoryService } from './accesscode-in-memory.service';
import { AccesscodeRestService } from './accesscode-rest.service';
import { HttpClient } from '@angular/common/http';
import { BackendConfig, BackendType } from '../../config';
import { ExistingAccessCodeFilter, AccessCodeResponse } from '../response-models/interfaces';

@Injectable()
export class AccesscodeService implements IAccessCodeService {

  private usedImplementation: IAccessCodeService;

  constructor(private injector: Injector, private http: HttpClient) {
    const backendConfig: BackendConfig = this.injector.get(BackendConfig);
    if (backendConfig.environmentType === BackendType.IN_MEMORY) {
      this.usedImplementation = new AccesscodeInMemoryService();
    } else {
      this.usedImplementation = new AccesscodeRestService(http);
    }
  }

  userConfirmation(token: string): Observable<AccessCodeResponse> {
    return this.usedImplementation.userConfirmation(token);
  }

  getAccessCode(codeId: number): Observable<AccessCodeResponse> {
    return this.usedImplementation.getAccessCode(codeId);
  }

  getAttendingAccessCodeByQueueId(queueId: number): Observable<AccessCodeResponse> {
    return this.usedImplementation.getAttendingAccessCodeByQueueId(queueId);
  }

  getExistingAccessCode(existingAccessCodeFilter: ExistingAccessCodeFilter): Observable<AccessCodeResponse> {
    return this.usedImplementation.getExistingAccessCode(existingAccessCodeFilter);
  }
}
