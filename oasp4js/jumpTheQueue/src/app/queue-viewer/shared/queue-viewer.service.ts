import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { config } from '../../config';

@Injectable()
export class QueueViewerService {

  constructor(private http: HttpClient) { }

  getQueuers(): Observable<any> {
    return this.http.post<any>(`${config.basePath}visitormanagement/v1/visitor/search`, {});
  }

}
