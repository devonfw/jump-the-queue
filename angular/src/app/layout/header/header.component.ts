import { Component } from "@angular/core";
import { AuthService } from "src/app/core/authentication/auth.service";
import { LoginService } from "src/app/form-login/components/login/services/login.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"],
})
export class HeaderComponent {
  constructor(
    public authService: AuthService,
    private loginService: LoginService
  ) {}

  onClickLogout(): void {
    this.loginService.logout();
  }
}
