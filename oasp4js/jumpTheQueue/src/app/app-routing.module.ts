import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { NotFoundComponent } from './core/not-found/not-found.component';
import { AccessComponent } from './access/access.component';
import { EmailConfirmationComponent } from './email-confirmation/email-confirmation.component';
import { UserAreaComponent } from './user-area/user-area.component';
import { CodeDetailComponent } from './user-area/code-detail/code-detail.component';
import { QueueDetailComponent } from './user-area/queue-detail/queue-detail.component';
import { OwnerAreaComponent } from './owner-area/owner-area.component';

import { AuthGuard } from './core/authentication/auth.guard';

const appRoutes: Routes = [
    { path: 'owner', component: OwnerAreaComponent },
    { path: 'queue', component: UserAreaComponent, canActivate: [AuthGuard] },
    { path: 'confirmation/:token', component: EmailConfirmationComponent },
    { path: 'access', component: AccessComponent },
    { path: '', redirectTo: '/access', pathMatch: 'full' },
    { path: '**', component: NotFoundComponent },
];

@NgModule({
    imports: [
        RouterModule.forRoot(
            appRoutes,
            { enableTracing: true }, // <-- debugging purposes only
        ),
    ],
    exports: [
        RouterModule,
    ],
})
export class AppRoutingModule { }
