import { Component, OnInit } from '@angular/core';
import { OwnerAreaService } from './shared/owner-area.service';
import { AccessCode, Queue } from '../shared/models/interfaces';
import { attendingAccessCode } from '../backend/mock-data';

@Component({
  selector: 'app-owner-area',
  templateUrl: './owner-area.component.html',
  styleUrls: ['./owner-area.component.scss']
})
export class OwnerAreaComponent implements OnInit {

  attendingAccessCode: string;
  queueName: string;

  constructor(private ownerAreaService: OwnerAreaService) {
    this.ownerAreaService.getAttendingAccessCode()
      .then(response => this.populateData(response));
  }

  ngOnInit() { }

  next() {
    this.ownerAreaService.attend()
      .then(response => this.populateData(response));
  }

  populateData(response: any): void {
    this.attendingAccessCode = response.code;
    this.queueName = response.queue.descriptionText;
  }
}
