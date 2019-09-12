
import { TestBed, inject } from '@angular/core/testing';
import { AuthService } from './auth.service';
import { CoreModule } from 'src/app/shared/core.module';

describe('AuthService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
        imports: [CoreModule],
        providers: [AuthService],
    });
  });

  it('should create', inject([AuthService], (service: AuthService) => {
    expect(service).toBeTruthy();
  }));
});
