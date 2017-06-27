import { CovalentLayoutModule, CovalentDataTableModule } from '@covalent/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from '@angular/material';
import 'HammerJS';

import { AppComponent } from './app.component';
import { appRoutes } from 'app/app.routes';
import { AccessComponent } from './access/access.component';
import { AccessService } from './access/shared/access.service';
import { CodeViewerComponent } from './code-viewer/code-viewer.component';
import { QueueViewerComponent } from './queue-viewer/queue-viewer.component';
import { AuthGuard } from './shared/authentication/auth-guard.service';
import { AuthService } from './shared/authentication/auth.service';
import { QueueViewerService } from 'app/queue-viewer/shared/queue-viewer.service';

@NgModule({
  declarations: [
    AppComponent,
    AccessComponent,
    CodeViewerComponent,
    QueueViewerComponent
  ],
  imports: [
    BrowserModule,
    appRoutes,
    FormsModule,
    CovalentLayoutModule,
    CovalentDataTableModule,
    MaterialModule,
    BrowserAnimationsModule,
    HttpModule
  ],
  providers: [
    QueueViewerService,
    AccessService,
    AuthGuard,
    AuthService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
