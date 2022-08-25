import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";

import { GuardianComponent } from "./components/guardian/guardian.component";
import { GuardianDetailsComponent } from "./components/guardian-details/guardian-details.component";


const routes: Routes = [
  { path: '', component: GuardianComponent, children: [
      { path: ':id', component: GuardianDetailsComponent }
    ]}
]


@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class GuardianRoutingModule {

}
