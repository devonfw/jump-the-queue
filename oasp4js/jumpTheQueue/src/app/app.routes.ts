import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { AccessComponent } from 'app/access/access.component';
import { CodeViewerComponent } from 'app/code-viewer/code-viewer.component';
import { QueueViewerComponent } from "app/queue-viewer/queue-viewer.component";


const routes: Routes = [
  { path: 'access', component: AccessComponent},
  { path: 'code', component: CodeViewerComponent},
  { path: 'queue', component: QueueViewerComponent},
  { path: '**', redirectTo: '/access', pathMatch: 'full' }];

export const appRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
