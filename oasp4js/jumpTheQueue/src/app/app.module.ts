import { CovalentLayoutModule } from '@covalent/core';
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
import { CodeViewerComponent } from './code-viewer/code-viewer.component';

@NgModule({
  declarations: [
    AppComponent,
    AccessComponent,
    CodeViewerComponent
  ],
  imports: [
    BrowserModule,
    appRoutes,
    FormsModule,
    CovalentLayoutModule,
    MaterialModule,
    BrowserAnimationsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
