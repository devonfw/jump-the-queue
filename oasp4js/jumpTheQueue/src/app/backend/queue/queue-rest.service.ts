import { Injectable } from '@angular/core';
import { IQueueService } from './queue.service-interface';
import { Observable } from 'rxjs/Observable';
import { AccessCodeResponse } from '../response-models/interfaces';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

@Injectable()
export class QueueRestService implements IQueueService {

  private readonly attendAccessCodeAction: string = 'queuemanagement/v1/queue/attend/';

  constructor(private http: HttpClient) { }

  attendAccessCode(queueId: number): Observable<AccessCodeResponse> {
    return this.http.put<AccessCodeResponse>(`${environment.restServiceRoot}${this.attendAccessCodeAction}` + queueId, null);
  }
}
