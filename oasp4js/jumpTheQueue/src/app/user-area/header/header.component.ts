import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/authentication/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  queueLogo;
  queueName;

  constructor(private authService: AuthService,
              private router: Router) {
    this.queueLogo = (this.authService.getQueue()) ? this.authService.getQueue().logo : 'undefined';
    this.queueName = (this.authService.getQueue()) ? this.authService.getQueue().descriptionText : 'undefined';
  }

  ngOnInit() {
  }

  logout(): void {
    this.authService.setLogged(false);
    this.router.navigate(['access']);
  }
}
