import { AccessService } from './shared/access.service';

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-access',
  templateUrl: './access.component.html',
  styleUrls: ['./access.component.css']
})
export class AccessComponent implements OnInit {

  constructor(private accessService: AccessService) { }

  ngOnInit(): void {
  }

  submitAccess(formValue): void {
    this.accessService.login(formValue.value.name, formValue.value.email, formValue.value.phone);
    formValue.reset();
  }

}
