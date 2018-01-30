import { TestBed, inject } from '@angular/core/testing';

import { UserAccessService } from './user-access.service';

describe('UserAccessService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserAccessService]
    });
  });

  it('should be created', inject([UserAccessService], (service: UserAccessService) => {
    expect(service).toBeTruthy();
  }));
});
