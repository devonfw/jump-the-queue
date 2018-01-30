import { TestBed, inject } from '@angular/core/testing';

import { UserAreaService } from './user-area.service';

describe('UserAreaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserAreaService]
    });
  });

  it('should be created', inject([UserAreaService], (service: UserAreaService) => {
    expect(service).toBeTruthy();
  }));
});
