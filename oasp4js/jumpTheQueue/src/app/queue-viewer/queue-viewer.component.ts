import { AuthService } from '../shared/authentication/auth.service';
import { QueueViewerService } from './shared/queue-viewer.service';

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ITdDataTableColumn } from '@covalent/core';
import { Observable } from 'rxjs/Rx';
import * as moment from 'moment';

@Component({
  selector: 'app-queue-viewer',
  templateUrl: './queue-viewer.component.html',
  styleUrls: ['./queue-viewer.component.css']
})
export class QueueViewerComponent implements OnInit {

  columns: ITdDataTableColumn[] = [
    { name: 'visitor.name', label: 'Name'},
    { name: 'code.dateAndTime', label: 'Hour', format: ( (v: string) => moment(v).format('LLL') ) },
    { name: 'code.code',  label: 'Code'}];

  queuers: Observable<any>;

  constructor(private router: Router,
              private auth: AuthService,
              private queueService: QueueViewerService) { }

  ngOnInit(): void {
    this.queuers = this.queueService.getQueuers();
  }

  navigateCode(): void {
    this.router.navigate(['code']);
  }

}
