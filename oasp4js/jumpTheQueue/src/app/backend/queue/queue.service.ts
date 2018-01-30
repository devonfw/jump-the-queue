import { Injectable, Injector } from '@angular/core';
import { IQueueService } from './queue.service-interface';
import { QueueInMemoryService } from './queue-in-memory.service';
import { QueueRestService } from './queue-rest.service';
import { HttpClient } from '@angular/common/http';
import { BackendConfig, BackendType } from '../../config';
import { Observable } from 'rxjs/Observable';
import { AccessCodeResponse } from '../response-models/interfaces';

@Injectable()
export class QueueService implements IQueueService {

  private usedImplementation: IQueueService;

  constructor(private injector: Injector, private http: HttpClient) {
    const backendConfig: BackendConfig = this.injector.get(BackendConfig);
    if (backendConfig.environmentType === BackendType.IN_MEMORY) {
      this.usedImplementation = new QueueInMemoryService();
    } else {
      this.usedImplementation = new QueueRestService(http);
    }
  }

  attendAccessCode(queueId: number): Observable<AccessCodeResponse> {
    return this.usedImplementation.attendAccessCode(queueId);
  }
}
