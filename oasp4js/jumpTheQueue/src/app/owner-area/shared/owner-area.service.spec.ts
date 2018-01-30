import { TestBed, inject } from '@angular/core/testing';

import { OwnerAreaService } from './owner-area.service';

describe('OwnerAreaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OwnerAreaService]
    });
  });

  it('should be created', inject([OwnerAreaService], (service: OwnerAreaService) => {
    expect(service).toBeTruthy();
  }));
});
