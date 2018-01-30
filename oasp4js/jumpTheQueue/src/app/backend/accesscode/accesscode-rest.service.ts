import { Injectable } from '@angular/core';
import { IAccessCodeService } from './accesscode.service-interface';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { AccessCodeResponse, ExistingAccessCodeFilter } from '../response-models/interfaces';
import { environment } from '../../../environments/environment';

@Injectable()
export class AccesscodeRestService implements IAccessCodeService {

  private readonly getVisitorAccessCodeAction: string = 'accesscodemanagement/v1/accesscode/visitor/';
  private readonly getAccessCodeAction: string = 'accesscodemanagement/v1/accesscode/';
  private readonly getAttendingCodeAction: string = 'accesscodemanagement/v1/accesscode/attending/';
  private readonly getExistingCodeAction: string = 'accesscodemanagement/v1/accesscode/exists/';

  constructor(private http: HttpClient) { }

  userConfirmation(token: string): Observable<AccessCodeResponse> {
    return this.http.get<AccessCodeResponse>(`${environment.restServiceRoot}${this.getVisitorAccessCodeAction}` + token);
  }

  getAccessCode(codeId: number): Observable<AccessCodeResponse> {
    return this.http.get<AccessCodeResponse>(`${environment.restServiceRoot}${this.getAccessCodeAction}` + codeId);
  }

  getAttendingAccessCodeByQueueId(queueId: number): Observable<AccessCodeResponse> {
    return this.http.get<AccessCodeResponse>(`${environment.restServiceRoot}${this.getAttendingCodeAction}` + queueId);
  }

  getExistingAccessCode(existingAccessCodeFilter: ExistingAccessCodeFilter): Observable<AccessCodeResponse> {
    return this.http.post<AccessCodeResponse>(`${environment.restServiceRoot}${this.getExistingCodeAction}`, existingAccessCodeFilter);
  }
}
