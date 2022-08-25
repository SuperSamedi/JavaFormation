import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import { LoginComponent } from './components/login/login.component';
import {SignInComponent} from "./modules/security/components/sign-in/sign-in.component";
import {RegisterComponent} from "./modules/security/components/register/register.component";

const routes: Routes = [
  { path: 'guardians', loadChildren: () => import("./pages/guardian/guardian.module").then(m => m.GuardianModule) },
  { path: 'sign-in',  component: SignInComponent },
  { path: 'sign-up', component: RegisterComponent }
]

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
