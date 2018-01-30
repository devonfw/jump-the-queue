import { Component, OnInit } from '@angular/core';
import { UserAreaService } from '../shared/user-area.service';
import { Subscription } from 'rxjs/Subscription';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { AuthService } from '../../core/authentication/auth.service';
import { Observable } from 'rxjs/Observable';
import { AccessCode } from '../../shared/models/interfaces';
import 'rxjs/add/observable/timer';

@Component({
  selector: 'app-queue-detail',
  templateUrl: './queue-detail.component.html',
  styleUrls: ['./queue-detail.component.scss']
})
export class QueueDetailComponent implements OnInit, OnDestroy {

  private readonly pollingFrequency = 3000; // 3 Seconds

  attendingCode: string;

  private timer;
  private timerSubscription: Subscription;

  constructor(private userAreaService: UserAreaService,
    private authService: AuthService) { }

  ngOnInit() {
    this.timer = Observable.timer(0, this.pollingFrequency);
    this.timerSubscription = this.timer.subscribe(t => this.updateAccessCode());
  }

  ngOnDestroy(): void {
    this.timerSubscription.unsubscribe();
  }

  updateAccessCode(): void {
    this.userAreaService.getAttendingAccessCode()
      .then((accessCode: AccessCode) => this.populateData(accessCode));
  }

  populateData(accessCode: AccessCode): void {
    if (accessCode) {
      this.attendingCode = this.userAreaService.generateAccessCodeByPriority(accessCode);
    }
  }
}
