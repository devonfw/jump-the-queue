import { Component, OnInit } from '@angular/core';
import { EmailConfirmationService } from './shared/email-confirmation.service';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-email-confirmation',
  templateUrl: './email-confirmation.component.html',
  styleUrls: ['./email-confirmation.component.scss']
})
export class EmailConfirmationComponent implements OnInit {

  private token: string;

  constructor(private emailConfirmationService: EmailConfirmationService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap
      .subscribe((params: ParamMap) => {
        this.token = params.get('token');
        this.emailConfirmationService.sendUserEmailConfirmation(this.token);
      });
  }

}
