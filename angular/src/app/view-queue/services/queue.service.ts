import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {
  Queue,
  FilterQueue,
  Pageable,
  QueueArray,
} from 'src/app/shared/backendModels/interfaces';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class QueueService {
  private baseUrl = environment.baseUrlRestServices;

  constructor(private router: Router, private http: HttpClient) {}

  getActiveQueue(): Observable<Queue> {
    const filters: FilterQueue = new FilterQueue();
    filters.active = true;
    const pageable: Pageable = new Pageable();
    pageable.pageNumber = 0;
    pageable.pageSize = 1;
    pageable.sort = [];
    filters.pageable = pageable;
    return this.http
      .post<QueueArray>(
        `${this.baseUrl}` + '/queuemanagement/v1/queue/search',
        filters,
      )
      .pipe(map((queues) => queues.content[0]));
  }
}
