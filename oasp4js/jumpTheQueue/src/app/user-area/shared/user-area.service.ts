import { Injectable } from '@angular/core';
import { AuthService } from '../../core/authentication/auth.service';
import { AccesscodeService } from '../../backend/accesscode/accesscode.service';
import { AccessCode } from '../../shared/models/interfaces';
import { AccessCodeResponse } from '../../backend/response-models/interfaces';
import { SnackBarService } from '../../core/snackService/snackService.service';

@Injectable()
export class UserAreaService {

  constructor(private authService: AuthService,
    private accesscodeService: AccesscodeService,
    private snackBar: SnackBarService) { }

  updateAccessCodeData() {
    return new Promise<AccessCode>((resolve, reject) => {
      this.accesscodeService.getAccessCode(this.authService.getAccessCode().id)
        .subscribe((accessCodeResponse: AccessCodeResponse) => {
          const accessCode: AccessCode = accessCodeResponse.accessCode;
          this.authService.setAccessCode(accessCode);
          resolve(accessCode);
        }, (err: any) => {
          this.snackBar.openSnack(err.message, 4000, 'red');
          reject(err);
        });
    });
  }

  getAttendingAccessCode() {
    return new Promise<AccessCode>((resolve, reject) => {
      this.accesscodeService.getAttendingAccessCodeByQueueId(this.authService.getQueue().id)
        .subscribe((accessCodeResponse: AccessCodeResponse) => {
          const accessCode: AccessCode = accessCodeResponse.accessCode;
          resolve(accessCode);
        }, (err: any) => {
          this.snackBar.openSnack(err.message, 4000, 'red');
          reject(err);
        });
    });
  }

  generateAccessCodeByPriority(accessCode: AccessCode): string {
    const priority: string = accessCode.priority ? 'A' : 'Q';
    return priority + accessCode.code;
  }
}
