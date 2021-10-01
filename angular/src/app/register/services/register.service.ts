import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Visitor } from 'src/app/shared/backendModels/interfaces';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import {
  FilterVisitor,
  Pageable,
  VisitorArray,
} from 'src/app/shared/backendModels/interfaces';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  private baseUrl = environment.baseUrlRestServices;

  constructor(private http: HttpClient) {}

  getVisitorByUsername(username: string): Observable<Visitor> {
    const filters: FilterVisitor = new FilterVisitor();
    const pageable: Pageable = new Pageable();

    pageable.pageNumber = 0;
    pageable.pageSize = 1;
    pageable.sort = [];
    filters.username = username;
    filters.pageable = pageable;
    return this.http
      .post<VisitorArray>(
        `${this.baseUrl}` + '/visitormanagement/v1/visitor/search',
        filters,
      )
      .pipe(
        map((visitors) => {
          return visitors.content[0];
        }),
      );
  }

  registerVisitor(visitor: Visitor): Observable<Visitor> {
    return this.http.post<Visitor>(
      `${this.baseUrl}` + '/visitormanagement/v1/visitor',
      visitor,
    );
  }
}
