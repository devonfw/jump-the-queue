import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormLoginComponent } from './form-login.component';
import { CoreModule } from '../shared/core.module';
import { LoginModule } from './components/login/login.module';

@NgModule({
  imports: [CommonModule, CoreModule, LoginModule],
  providers: [],
  declarations: [FormLoginComponent],
  exports: [FormLoginComponent],
})
export class FormLoginModule {}
