import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OwnerAreaComponent } from './owner-area.component';
import { CoreModule } from '../core/core.module';
import { OwnerAreaService } from './shared/owner-area.service';

@NgModule({
  imports: [
    CommonModule,
    CoreModule,
  ],
  declarations: [OwnerAreaComponent],
  providers: [
    OwnerAreaService,
  ]
})
export class OwnerAreaModule { }
