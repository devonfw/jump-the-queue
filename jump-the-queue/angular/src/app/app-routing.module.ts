import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormLoginComponent } from './form-login/form-login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuardService } from './core/authentication/auth-guard.service';
import { ViewQueueComponent } from './view-queue/view-queue.component';

const appRoutes: Routes = [
  { path: 'FormLogin', component: FormLoginComponent},  // Redirect if url path is /FormLogin.
  { path: 'Register', component: RegisterComponent},    // Redirect if url path is /Register.
  { path: 'ViewQueue', component: ViewQueueComponent,
  canActivate: [AuthGuardService]},  // Redirect if url path is /ViewQueue, check if can activate with the AuthGuardService.
  { path: '**', redirectTo: '/FormLogin', pathMatch: 'full' }  // Redirect if url path do not match with any other route.
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }, // <-- debugging purposes only
    ),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
