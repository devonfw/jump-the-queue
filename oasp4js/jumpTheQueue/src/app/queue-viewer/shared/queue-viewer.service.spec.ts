import { inject, TestBed } from '@angular/core/testing';
import { HttpModule } from '@angular/http';

import { AuthService } from '../../shared/authentication/auth.service';
import { QueueViewerService } from './queue-viewer.service';

describe('QueueViewerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QueueViewerService],
      imports: [HttpModule],
    });
  });

  it('should ...', inject([QueueViewerService], (service: QueueViewerService) => {
    expect(service).toBeTruthy();
  }));
});
