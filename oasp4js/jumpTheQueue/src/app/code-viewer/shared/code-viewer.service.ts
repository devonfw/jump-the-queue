import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CodeViewerService {

  constructor() { }

  getCode(): Observable<string> {
    return Observable.of('Q06');
  }

}
