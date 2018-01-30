import { Injectable } from '@angular/core';
import { QueueService } from '../../backend/queue/queue.service';
import { AccesscodeService } from '../../backend/accesscode/accesscode.service';
import { environment } from '../../../environments/environment.prod';
import { AccessCodeResponse } from '../../backend/response-models/interfaces';
import { AccessCode, Queue } from '../../shared/models/interfaces';
import { SnackBarService } from '../../core/snackService/snackService.service';

@Injectable()
export class OwnerAreaService {

  constructor(private queueService: QueueService,
    private accessCodeService: AccesscodeService,
    private snackBar: SnackBarService) { }

  getAttendingAccessCode() {
    return new Promise((resolve, reject) => {
      this.accessCodeService.getAttendingAccessCodeByQueueId(environment.queueId)
        .subscribe((accessCodeResponse: AccessCodeResponse) => {
          resolve({
            code: this.generateAccessCodeByPriority(accessCodeResponse.accessCode),
            queue: accessCodeResponse.queue
          });
        }, (err: any) => {
          this.snackBar.openSnack(err.message, 4000, 'red');
        });
    });
  }

  attend() {
    return new Promise((resolve, reject) => {
      this.queueService.attendAccessCode(environment.queueId)
        .subscribe((accessCodeResponse: AccessCodeResponse) => {
          resolve({
            code: this.generateAccessCodeByPriority(accessCodeResponse.accessCode),
            queue: accessCodeResponse.queue
          });
        }, (err: any) => {
          this.snackBar.openSnack(err.message, 4000, 'red');
        });
    });
  }

  private generateAccessCodeByPriority(accessCode: AccessCode): string {
    const priority: string = accessCode.priority ? 'A' : 'Q';
    return priority + accessCode.code;
  }
}
