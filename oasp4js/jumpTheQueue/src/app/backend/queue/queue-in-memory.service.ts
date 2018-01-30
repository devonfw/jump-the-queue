import { Injectable } from '@angular/core';
import { IQueueService } from './queue.service-interface';
import { Observable } from 'rxjs/Observable';
import { AccessCodeResponse } from '../response-models/interfaces';
import { Subscriber } from 'rxjs/Subscriber';
import { attendingAccessCode } from '../mock-data';

@Injectable()
export class QueueInMemoryService implements IQueueService {

  constructor() { }

  attendAccessCode(queueId: number): Observable<AccessCodeResponse> {
    return new Observable<AccessCodeResponse>((observer: Subscriber<AccessCodeResponse>) => {
      setTimeout(() => {
        attendingAccessCode.accessCode.code++;
        observer.next(attendingAccessCode);
        observer.complete();
      }, 2000);
    });
  }
}
