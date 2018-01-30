import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccessComponent } from './access.component';
import { RegisterComponent } from './register/register.component';
import { CoreModule } from '../core/core.module';
import { BackendModule } from '../backend/backend.module';
import { UserAccessService } from './shared/user-access.service';
import { ExistCodeComponent } from './exist-code/exist-code.component';
import { TermsDialogComponent } from './terms-dialog/terms-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    CoreModule,
  ],
  declarations: [
    AccessComponent,
    RegisterComponent,
    ExistCodeComponent,
    TermsDialogComponent,
  ],
  providers: [
    UserAccessService
  ],
  entryComponents: [
    TermsDialogComponent
  ]
})
export class AccessModule { }
