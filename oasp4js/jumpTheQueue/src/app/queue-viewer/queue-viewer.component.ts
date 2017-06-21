import { QueueViewerService } from './shared/queue-viewer.service';

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ITdDataTableColumn } from '@covalent/core';

@Component({
  selector: 'app-queue-viewer',
  templateUrl: './queue-viewer.component.html',
  styleUrls: ['./queue-viewer.component.css']
})
export class QueueViewerComponent implements OnInit {

  columns: ITdDataTableColumn[] = [
    { name: 'code',  label: 'Code'},
    { name: 'hour', label: 'Hour' },
    { name: 'name', label: 'Name'}];

  queuers: any[];

  constructor(private router: Router,
              private queueService: QueueViewerService) { }

  ngOnInit(): void {
    this.queueService.getQueuers().subscribe( (data) => {
      this.queuers = data;
    });
  }

  navigateCode(): void {
    this.router.navigate(['code']);
  }

}
