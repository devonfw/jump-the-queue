import { Component, OnInit } from '@angular/core';
import { RegisterService } from './services/register.service';
import { Visitor } from '../shared/backendModels/interfaces';
import { Router } from '@angular/router';
import { LoginService } from '../form-login/components/login/services/login.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private registerService: RegisterService, private loginService: LoginService
    , private router: Router, public snackBar: MatSnackBar) { }

  submitRegister(formValue): void {
    const visitor: Visitor = new Visitor();
    visitor.username = formValue.username;
    visitor.name = formValue.name;
    visitor.phoneNumber = formValue.phoneNumber;
    visitor.password = formValue.password;
    visitor.acceptedCommercial = formValue.acceptedCommercial;
    visitor.acceptedTerms = formValue.acceptedTerms;
    visitor.userType = false;

    this.registerService.registerVisitor(visitor).subscribe(
      (visitorResult: Visitor) => {
        this.loginService.login(visitorResult.username, visitorResult.password);
      }, // When call is received
      (err) =>  this.snackBar.open(err.error.message, 'OK', {
        duration: 5000,
      }), // When error is received from the call
    );
  }

  ngOnInit() {
  }
}
