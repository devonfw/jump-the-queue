import { Component } from '@angular/core';
import { AuthService } from './core/authentication/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';

  constructor(private authService: AuthService,
    private router: Router) {
    this.authService.regenerateSession();
    if (this.authService.isLogged()) {
      router.navigate(['queue']);
    }
  }
}
