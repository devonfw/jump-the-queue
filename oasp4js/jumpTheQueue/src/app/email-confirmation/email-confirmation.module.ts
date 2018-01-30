import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmailConfirmationComponent } from './email-confirmation.component';
import { CoreModule } from '../core/core.module';
import { EmailConfirmationService } from './shared/email-confirmation.service';

@NgModule({
  imports: [
    CommonModule,
    CoreModule
  ],
  declarations: [
    EmailConfirmationComponent
  ],
  providers: [
    EmailConfirmationService
  ]
})
export class EmailConfirmationModule { }
