import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CoreModule } from 'src/app/shared/core.module';
import { LoginComponent } from './login.component';
import { LoginService } from './services/login.service';

@NgModule({
  imports: [CommonModule, CoreModule],
  providers: [LoginService],
  declarations: [LoginComponent],
  exports: [LoginComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class LoginModule {}
