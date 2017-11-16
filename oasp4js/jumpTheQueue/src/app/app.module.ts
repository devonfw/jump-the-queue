// Covalent imports
import {
  CovalentLayoutModule,
  CovalentCommonModule,
  CovalentDataTableModule
} from '@covalent/core';

// Material imports
import {
  MatCardModule,
  MatInputModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatIconModule,
  MatSnackBarModule,
  MatProgressBarModule,
} from '@angular/material';
import { CdkTableModule } from '@angular/cdk/table';

// Angular core imports
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import 'HammerJS';

// Application components and services
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
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
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    CdkTableModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatIconModule,
    MatProgressBarModule,
    MatSnackBarModule,
    CovalentLayoutModule,
    CovalentCommonModule,
    CovalentDataTableModule,
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
