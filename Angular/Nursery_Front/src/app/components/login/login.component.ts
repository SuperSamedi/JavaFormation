import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import { Token } from 'src/app/pages/guardian/models/token';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: any = "";
  password: any = "";

  constructor( private _http: HttpClient, private _router: Router ) { }

  // set username(value: string) {
  //   this._username = value;
  // }
  // set password(value: string) {
  //   this._password = value;
  // }


  ngOnInit(): void {
  }

  login() {
    this._http.post<Token>(environment.api.url + "/account/login", { username: this.username, password: this.password }).subscribe(response => {
      console.log(response);
      localStorage.setItem(response.key, response.value);
      this._router.navigate(["guardians"])
    })

  }
}
