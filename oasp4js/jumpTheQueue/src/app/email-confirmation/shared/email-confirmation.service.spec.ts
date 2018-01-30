import { TestBed, inject } from '@angular/core/testing';

import { EmailConfirmationService } from './email-confirmation.service';

describe('EmailConfirmationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmailConfirmationService]
    });
  });

  it('should be created', inject([EmailConfirmationService], (service: EmailConfirmationService) => {
    expect(service).toBeTruthy();
  }));
});
