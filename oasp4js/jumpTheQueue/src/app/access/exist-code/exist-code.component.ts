import { Component, OnInit } from '@angular/core';
import { UserAccessService } from '../shared/user-access.service';

@Component({
  selector: 'app-exist-code',
  templateUrl: './exist-code.component.html',
  styleUrls: ['./exist-code.component.scss']
})
export class ExistCodeComponent implements OnInit {

  constructor(private userAccessService: UserAccessService) { }

  ngOnInit() {
  }

  submitAccess(formValue): void {
    this.userAccessService.getExistingAccessCode(formValue.get('validationCode').value);
  }

  getEmailFromService(): string {
    return this.userAccessService.getEmail();
  }

  getPhoneFromService(): string {
    return this.userAccessService.getPhone();
  }
}
