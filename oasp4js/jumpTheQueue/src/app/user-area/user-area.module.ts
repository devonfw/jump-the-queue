import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserAreaComponent } from './user-area.component';
import { CodeDetailComponent } from './code-detail/code-detail.component';
import { QueueDetailComponent } from './queue-detail/queue-detail.component';
import { HeaderComponent } from './header/header.component';
import { CoreModule } from '../core/core.module';
import { AppRoutingModule } from '../app-routing.module';
import { UserAreaService } from './shared/user-area.service';

@NgModule({
  imports: [
    CommonModule,
    CoreModule,
  ],
  providers: [
    UserAreaService,
  ],
  declarations: [
    UserAreaComponent,
    CodeDetailComponent,
    QueueDetailComponent,
    HeaderComponent
  ],
})
export class UserAreaModule { }
