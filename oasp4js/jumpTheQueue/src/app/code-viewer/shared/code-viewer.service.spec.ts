import { TestBed, inject } from '@angular/core/testing';

import { CodeViewerService } from './code-viewer.service';

describe('CodeViewerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CodeViewerService]
    });
  });

  it('should ...', inject([CodeViewerService], (service: CodeViewerService) => {
    expect(service).toBeTruthy();
  }));
});
