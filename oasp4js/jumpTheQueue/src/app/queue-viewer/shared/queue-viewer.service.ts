import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { config } from '../../config';

@Injectable()
export class QueueViewerService {

  constructor(private http: Http) { }

  getQueuers(): Observable<any> {
    return this.http.post(`${config.basePath}visitormanagement/v1/visitor/search`, {})
          .map(res => res.json());
  }

}
