import { Injectable } from '@angular/core';
import { UserService } from '../../backend/user/user.service';
import { SnackBarService } from '../../core/snackService/snackService.service';
import { AccesscodeService } from '../../backend/accesscode/accesscode.service';
import { AuthService } from '../../core/authentication/auth.service';
import { Router } from '@angular/router';
import { TermsService } from '../../backend/terms/terms.service';
import { MatDialogRef, MatDialog } from '@angular/material';
import { TermsDialogComponent } from '../terms-dialog/terms-dialog.component';
import {
  UserResponse,
  AccessCodeResponse,
  TermsResponse,
  ExistingAccessCodeFilter,
  UserFilter
} from '../../backend/response-models/interfaces';
import { environment } from '../../../environments/environment';

@Injectable()
export class UserAccessService {

  private email: string;

  private phone: string;

  constructor(private snackBar: SnackBarService,
    public dialog: MatDialog,
    private userService: UserService,
    private accessCodeService: AccesscodeService,
    private termsService: TermsService,
    private authService: AuthService,
    private router: Router) { }

  register(name: string, email: string, phone: number, commercial: boolean): void {
    const user: UserFilter = {
      name: name,
      email: email,
      phone: phone,
      consent: Boolean(commercial),
      url: environment.domain,
      queueId: environment.queueId
    };
    this.userService.registerUser(user)
      .subscribe((res: UserResponse) => {
        this.snackBar.openSnack('Registration successful, check your email inbox', 4000, 'green');
      }, (err: any) => {
        this.snackBar.openSnack(err.message, 4000, 'red');
      });
  }

  getExistingAccessCode(code: string) {
    const existingAccessCodeFilter: ExistingAccessCodeFilter = {
      queueId: environment.queueId,
      identificator: code
    };
    if (this.email) {
      existingAccessCodeFilter.email = this.email;
    } else {
      existingAccessCodeFilter.phone = this.phone;
    }
    this.accessCodeService.getExistingAccessCode(existingAccessCodeFilter)
      .subscribe((accessCodeResponse: AccessCodeResponse) => {
        if (!accessCodeResponse.accessCode) {
          return this.snackBar.openSnack('Not found', 4000, 'red');
        }
        this.authService.setLogged(true);
        this.authService.setAccessCode(accessCodeResponse.accessCode);
        this.authService.setQueue(accessCodeResponse.queue);
        this.router.navigate(['queue']);
      }, (err: any) => {
        this.snackBar.openSnack(err.message, 4000, 'red');
      });
  }

  getTermsAndConditions() {
    this.termsService.getTerms(environment.queueId)
      .subscribe((terms: TermsResponse) => {
        this.openTermsDialog(terms.description);
      }, (err: any) => {
        this.snackBar.openSnack(err.message, 4000, 'red');
      });
  }

  openTermsDialog(terms: String): void {
    const dialogRef: MatDialogRef<TermsDialogComponent> = this.dialog.open(TermsDialogComponent, {
      width: '80%',
      data: terms.trim()
    });
  }

  getEmail(): string {
    return this.email;
  }

  setEmail(email: string): void {
    this.email = email;
  }

  getPhone(): string {
    return this.phone;
  }

  setPhone(phone: string): void {
    this.phone = phone;
  }
}
