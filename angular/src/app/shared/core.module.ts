import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatChipsModule } from '@angular/material/chips';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSliderModule } from '@angular/material/slider';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';
import { CdkTableModule } from '@angular/cdk/table';
import { CovalentChipsModule } from '@covalent/core/chips';
import { CovalentLayoutModule } from '@covalent/core/layout';
import { CovalentExpansionPanelModule } from '@covalent/core/expansion-panel';
import { CovalentDataTableModule } from '@covalent/core/data-table';
import { CovalentPagingModule } from '@covalent/core/paging';
import { CovalentDialogsModule } from '@covalent/core/dialogs';
import { CovalentLoadingModule } from '@covalent/core/loading';
import { CovalentMediaModule } from '@covalent/core/media';
import { CovalentNotificationsModule } from '@covalent/core/notifications';
import { CovalentCommonModule } from '@covalent/core/common';
import { AuthService } from '../core/authentication/auth.service';
import { AuthGuardService } from '../core/authentication/auth-guard.service';
import { HttpRequestInterceptorService } from './http-request-interceptor.service';

@NgModule({
  imports: [
    RouterModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    CovalentMediaModule,
    CovalentLayoutModule,
    CdkTableModule,
  ],
  exports: [
    CommonModule,
    CovalentChipsModule,
    CovalentLayoutModule,
    CovalentExpansionPanelModule,
    CovalentDataTableModule,
    CovalentPagingModule,
    CovalentDialogsModule,
    CovalentLoadingModule,
    CovalentMediaModule,
    CovalentNotificationsModule,
    CovalentCommonModule,
    CdkTableModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    HttpClientModule,
  ],
  declarations: [],
  providers: [
    HttpClientModule,
    AuthService,
    AuthGuardService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpRequestInterceptorService,
      multi: true,
    },
  ],
})
export class CoreModule {}
