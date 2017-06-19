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

  basicData: any[] = [
      {code: 'Q04', hour: '14:30', name: 'Elrich'},
      {code: 'Q05', hour: '14:40', name: 'Richard'},
      {code: 'Q06', hour: '14:50', name: 'Gabin'},
    ];

  constructor(private router: Router) { }

  ngOnInit() {
  }

  navigateCode() {
    this.router.navigate(['code']);
  }

}
