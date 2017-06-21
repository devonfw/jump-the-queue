import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class QueueViewerService {

  constructor() { }

  getQueuers(): Observable<any> {
    return Observable.of([
      {name: 'Erlich', hour: '14:00', code: 'Q02'},
      {name: 'Richard', hour: '14:20', code: 'Q04'},
      {name: 'Monica', hour: '14:35', code: 'Q05'},
      {name: 'user', hour: '14:45', code: 'Q06'},
    ]);
  }

}
