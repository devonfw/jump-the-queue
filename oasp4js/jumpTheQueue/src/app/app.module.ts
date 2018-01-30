import { BackendConfig } from './config';
import { environment } from '../environments/environment';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';
import { AccessModule } from './access/access.module';
import { AppRoutingModule } from './app-routing.module';
import { BackendModule } from './backend/backend.module';
import { EmailConfirmationModule } from './email-confirmation/email-confirmation.module';
import { UserAreaModule } from './user-area/user-area.module';
import { OwnerAreaModule } from './owner-area/owner-area.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    CoreModule,
    AccessModule,
    AppRoutingModule,
    BackendModule.forRoot({ restServiceRoot: environment.restServiceRoot, environmentType: environment.backendType }),
    EmailConfirmationModule,
    UserAreaModule,
    OwnerAreaModule,
  ],
  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
