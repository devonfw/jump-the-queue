import { NgModule, Optional, SkipSelf, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserService } from './user/user.service';
import { BackendConfig } from '../config';
import { AccesscodeService } from './accesscode/accesscode.service';
import { TermsService } from './terms/terms.service';
import { QueueService } from './queue/queue.service';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers: [
    UserService,
    AccesscodeService,
    TermsService,
    QueueService,
  ]
})
export class BackendModule {
  constructor(@Optional() @SkipSelf() parentModule: BackendModule) {
    if (parentModule) {
      throw new Error('BackendModule is already loaded. Import it in the AppModule only');
    }
  }

  static forRoot(backendConfig: BackendConfig): ModuleWithProviders {
    return {
      ngModule: BackendModule,
      providers: [
        { provide: BackendConfig, useValue: backendConfig },
      ],
    };
  }
}
