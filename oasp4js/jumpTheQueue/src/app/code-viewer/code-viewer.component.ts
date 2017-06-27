import { AuthService } from '../shared/authentication/auth.service';

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

  constructor(private router: Router,
              private auth: AuthService) { }

  ngOnInit(): void {
    this.code = this.auth.getCode();
    this.name = this.auth.getUser();
  }

  navigateQueue(): void {
    this.router.navigate(['queue']);
  }
}
