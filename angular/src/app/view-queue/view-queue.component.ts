import { Component, OnInit } from '@angular/core';
import { AccessCode, Queue } from '../shared/backendModels/interfaces';
import { Observable, timer } from 'rxjs';
import { AccessCodeService } from './services/access-code.service';
import { switchMap } from 'rxjs/operators';
import { AuthService } from '../core/authentication/auth.service';
import { QueueService } from './services/queue.service';

@Component({
  selector: 'app-view-queue',
  templateUrl: './view-queue.component.html',
  styleUrls: ['./view-queue.component.scss'],
})
export class ViewQueueComponent implements OnInit {
  accessCodeAttended$: Observable<AccessCode>;
  accessCodeVisitor$: Observable<AccessCode>;
  queue$: Observable<Queue>;

  constructor(
    private accessCodeService: AccessCodeService,
    private queueService: QueueService,
    private authService: AuthService,
  ) {}

  ngOnInit() {
    // Every minute we are going to update accessCodeAttended$ starting instantly
    this.accessCodeAttended$ = timer(0, 60000).pipe(
      // we switchMap and give it the value necesary from the accessCodeService
      switchMap(() => {
        return this.accessCodeService.getCurrentlyAttendedAccessCode();
      }),
    );
    this.accessCodeVisitor$ = this.accessCodeService.getVisitorAccessCode(
      this.authService.getUserId(),
    );
    this.queue$ = this.queueService.getActiveQueue();
  }

  onJoinQueue(queueId: number): void {
    this.accessCodeVisitor$ = this.accessCodeService.saveAccessCode(
      this.authService.getUserId(),
      queueId,
    );
  }

  onLeaveQueue(accessCodeId: number): void {
    this.accessCodeService.deleteAccessCode(accessCodeId);
    this.accessCodeVisitor$ = null;
  }
}
