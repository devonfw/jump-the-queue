import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { LoginService } from './services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private loginService: LoginService) {
  }

  ngOnInit() {
  }

  onRegisterClick(): void {
    this.router.navigate(['Register']);
  }
  submitLogin(loginFormValues): void {
    this.loginService.login(loginFormValues.username, loginFormValues.password);
  }
}
