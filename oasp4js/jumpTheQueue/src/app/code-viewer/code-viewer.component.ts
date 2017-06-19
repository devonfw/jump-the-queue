import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-code-viewer',
  templateUrl: './code-viewer.component.html',
  styleUrls: ['./code-viewer.component.css']
})
export class CodeViewerComponent implements OnInit {

  code: string;
  name: string;

  constructor(private router: Router) { }

  ngOnInit() {
    this.code = 'Q06';
    this.name = 'Someone';
  }

  navigateQueue() {

  }

}
