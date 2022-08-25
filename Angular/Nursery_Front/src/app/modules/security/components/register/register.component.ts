import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import { Router } from '@angular/router';
import { RegisterService } from '../../services/register.service';
import { SessionService } from '../../services/session.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm = new FormGroup({
    username: new FormControl("Frodo", [Validators.required, Validators.minLength(3)]),
    password: new FormControl("", [Validators.required, Validators.minLength(5)])
  })
  // invalid input field get marked with special dynamic classes. Can be styled!

  constructor(private _registerService: RegisterService, private _session: SessionService, private _router: Router) {}

  ngOnInit(): void {
    this.registerForm.patchValue({username: "Bilbo"});
  }

  onSubmit() {
    console.log(this.registerForm.valid);
    console.log(this.registerForm.value);
    console.log(this.registerForm.get("username")?.value);
    // todo: send to api
    // todo: login
    this._registerService.registerCall(this.registerForm.value).subscribe(data => {
      this._session.login(data);
      this._router.navigate([''])
    });
  }

}
