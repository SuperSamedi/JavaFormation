import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {SessionService} from "../../services/session.service";

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  username: string = "";
  password: string = "";


  constructor(private _auth: AuthenticationService, private _session: SessionService) { }

  ngOnInit(): void {
  }


  onSubmit() {
    console.log(this.username, this.password);
    this._auth.loginCall(this.username, this.password).subscribe(data => {
      console.log(data);
      this._session.login(data);
    })
  }

}
