import { Injectable } from '@angular/core';
import { SnackBarService } from '../../core/snackService/snackService.service';
import { AccesscodeService } from '../../backend/accesscode/accesscode.service';
import { AuthService } from '../../core/authentication/auth.service';
import { Router } from '@angular/router';
import { accessCode } from '../../backend/mock-data';
import { AccessCodeResponse } from '../../backend/response-models/interfaces';

@Injectable()
export class EmailConfirmationService {

  constructor(private accessCodeService: AccesscodeService,
              private authService: AuthService,
              private router: Router,
              public snackBar: SnackBarService) { }

  public sendUserEmailConfirmation(token: string): void {
    this.accessCodeService.userConfirmation(token)
      .subscribe((accessCodeResponse: AccessCodeResponse) => {
        this.authService.setLogged(true);
        this.authService.setAccessCode(accessCodeResponse.accessCode);
        this.authService.setQueue(accessCodeResponse.queue);
        this.snackBar.openSnack('Confirmation Successful', 4000, 'green');
        this.router.navigate(['queue']);
      }, (err: any) => {
        this.snackBar.openSnack(err.message, 4000, 'red');
      });
  }
}
