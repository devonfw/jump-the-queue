import { TestBed, inject } from '@angular/core/testing';

import { AccessService } from './access.service';

describe('AccessService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AccessService]
    });
  });

  it('should ...', inject([AccessService], (service: AccessService) => {
    expect(service).toBeTruthy();
  }));
});
