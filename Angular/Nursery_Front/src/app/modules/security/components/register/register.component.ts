import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

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

  ngOnInit(): void {
    this.registerForm.patchValue({username: "Bilbo"});
  }

  onSubmit() {
    console.log(this.registerForm.valid);
    console.log(this.registerForm.value);
    console.log(this.registerForm.get("username")?.value);
    // todo: send to api
    // todo: login
  }

}
