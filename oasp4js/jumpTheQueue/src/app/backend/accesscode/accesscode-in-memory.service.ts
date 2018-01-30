import { Injectable } from '@angular/core';
import { IAccessCodeService } from './accesscode.service-interface';
import { Observable } from 'rxjs/Observable';
import { accessCode, attendingAccessCode } from '../mock-data';
import { Subscriber } from 'rxjs/Subscriber';
import { AccessCodeResponse, ExistingAccessCodeFilter } from '../response-models/interfaces';

@Injectable()
export class AccesscodeInMemoryService implements IAccessCodeService {

  constructor() { }

  userConfirmation(token: string): Observable<AccessCodeResponse> {
    return new Observable<AccessCodeResponse>((observer: Subscriber<AccessCodeResponse>) => {
      setTimeout(() => {
        observer.next(accessCode);
        observer.complete();
      }, 2000);
    });
  }

  getAccessCode(codeId: number): Observable<AccessCodeResponse> {
    return new Observable<AccessCodeResponse>((observer: Subscriber<AccessCodeResponse>) => {
      setTimeout(() => {
        observer.next(accessCode);
        observer.complete();
      }, 2000);
    });
  }

  getAttendingAccessCodeByQueueId(queueId: number): Observable<AccessCodeResponse> {
    return new Observable<AccessCodeResponse>((observer: Subscriber<AccessCodeResponse>) => {
      setTimeout(() => {
        observer.next(attendingAccessCode);
        observer.complete();
      }, 2000);
    });
  }

  getExistingAccessCode(existingAccessCodeFilter: ExistingAccessCodeFilter): Observable<AccessCodeResponse> {
    return new Observable<AccessCodeResponse>((observer: Subscriber<AccessCodeResponse>) => {
      setTimeout(() => {
        observer.next(accessCode);
        observer.complete();
      }, 2000);
    });
  }
}
