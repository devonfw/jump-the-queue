import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserAccessService } from '../shared/user-access.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private userAccessService: UserAccessService) { }

  ngOnInit() {
  }

  submitAccess(formValue): void {
    this.userAccessService.register(
      formValue.get('name').value,
      formValue.get('email').value,
      formValue.get('phone').value,
      formValue.get('commercial').value,
    );
  }

  onClickTerms(): void {
    this.userAccessService.getTermsAndConditions();
  }

  onChangeEmail($event): void {
    this.userAccessService.setEmail($event);
  }

  onChangePhone($event): void {
    this.userAccessService.setPhone($event);
  }
}
