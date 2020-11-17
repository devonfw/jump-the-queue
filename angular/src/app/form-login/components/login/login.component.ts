import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  constructor(private router: Router, private loginService: LoginService) {}
  ngOnInit() {}

  onRegisterClick(): void {
    this.router.navigate(['Register']);
  }

  submitLogin(loginFormValues): void {
    this.loginService.login(loginFormValues.username, loginFormValues.password);
  }
}
