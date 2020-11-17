import { TestBed } from '@angular/core/testing';

import { AccessCodeService } from './access-code.service';

describe('AccessCodeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AccessCodeService = TestBed.get(AccessCodeService);
    expect(service).toBeTruthy();
  });
});
