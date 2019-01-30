import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import 'hammerjs';

// Application components and services
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FormLoginModule } from './form-login/form-login-module';
import { CoreModule } from './shared/core.module';
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './layout/header/header.component';
import { ViewQueueComponent } from './view-queue/view-queue.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HeaderComponent,
    ViewQueueComponent
  ],
  imports: [
    BrowserModule,
    FormLoginModule,
    CoreModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
