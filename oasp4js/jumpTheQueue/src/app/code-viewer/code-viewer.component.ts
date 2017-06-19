import { AuthService } from '../shared/authentication/auth.service';

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CodeViewerService } from 'app/code-viewer/shared/code-viewer.service';

@Component({
  selector: 'app-code-viewer',
  templateUrl: './code-viewer.component.html',
  styleUrls: ['./code-viewer.component.css']
})
export class CodeViewerComponent implements OnInit {

  code: string;
  name: string;

  constructor(private router: Router,
              private auth: AuthService,
              private codeService: CodeViewerService) { }

  ngOnInit(): void {
    this.codeService.getCode().subscribe((data: string) => {
      this.code = data;
    });
    this.name = this.auth.getUser();
  }

  navigateQueue(): void {
    this.router.navigate(['queue']);
  }
}
