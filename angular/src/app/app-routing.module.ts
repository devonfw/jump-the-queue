import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormLoginComponent } from './form-login/form-login.component';
import { RegisterComponent } from './register/register.component';
import { ViewQueueComponent } from './view-queue/view-queue.component';
import { AuthGuardService } from './core/authentication/auth-guard.service';

const appRoutes: Routes = [
  { path: 'FormLogin', component: FormLoginComponent }, // Redirect if url path is /FormLogin.
  { path: 'Register', component: RegisterComponent },
  {
    path: 'ViewQueue',
    component: ViewQueueComponent,
    canActivate: [AuthGuardService],
  }, // Redirect if url path is /Register.
  { path: '**', redirectTo: '/FormLogin', pathMatch: 'full' }, // Redirect if url path do not match any other route.
];
@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true, relativeLinkResolution: 'legacy' }, // <-- debugging purposes only
    ),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
