import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './shared/authentication/auth-guard.service';

import { AccessComponent } from 'app/access/access.component';
import { CodeViewerComponent } from 'app/code-viewer/code-viewer.component';
import { QueueViewerComponent } from 'app/queue-viewer/queue-viewer.component';


const appRoutes: Routes = [
  { path: 'access', component: AccessComponent },
  { path: 'code', component: CodeViewerComponent, canActivate: [AuthGuard] },
  { path: 'queue', component: QueueViewerComponent, canActivate: [AuthGuard] },
  { path: '**', redirectTo: '/access', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes, {
        enableTracing: true
      }, // <-- debugging purposes only
    ),
  ],
  exports: [
    RouterModule,
  ],
})
export class AppRoutingModule {}

