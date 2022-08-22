import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  toVerify?: number;
  invalidNumber: boolean = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  verifyParity() {
    if ( this.toVerify !== undefined ) {
      // this.router.navigateByUrl("/parity/" + this.toVerify);
      this.router.navigate(['parity', this.toVerify]);
    }
    else {
      this.invalidNumber = true;
    }
  }
}
