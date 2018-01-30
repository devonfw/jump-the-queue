import { Component, OnInit } from '@angular/core';
import { UserAreaService } from '../shared/user-area.service';
import { AuthService } from '../../core/authentication/auth.service';
import { OnDestroy } from '@angular/core/src/metadata/lifecycle_hooks';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';
import { AccessCode } from '../../shared/models/interfaces';
import 'rxjs/add/observable/timer';

@Component({
  selector: 'app-code-detail',
  templateUrl: './code-detail.component.html',
  styleUrls: ['./code-detail.component.scss']
})
export class CodeDetailComponent implements OnInit, OnDestroy {

  private readonly pollingFrequency = 3000; // 3 Seconds

  accessCode: string;
  estimatedTime: string;

  private timer;
  private timerSubscription: Subscription;

  constructor(private userAreaService: UserAreaService,
    private authService: AuthService) { }

  ngOnInit() {
    this.populateData(this.authService.getAccessCode());
    this.timer = Observable.timer(0, this.pollingFrequency);
    this.timerSubscription = this.timer.subscribe(t => this.updateAccessCode());
  }

  ngOnDestroy(): void {
    this.timerSubscription.unsubscribe();
  }

  updateAccessCode(): void {
    this.userAreaService.updateAccessCodeData()
      .then((accessCode: AccessCode) => this.populateData(accessCode));
  }

  populateData(accessCode: AccessCode): void {
    this.accessCode = this.userAreaService.generateAccessCodeByPriority(accessCode);
    this.estimatedTime = accessCode.estimatedTime;
  }
}
