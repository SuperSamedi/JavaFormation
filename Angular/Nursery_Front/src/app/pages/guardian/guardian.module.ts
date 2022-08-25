import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GuardianComponent } from './components/guardian/guardian.component';
import { GuardianDetailsComponent } from './components/guardian-details/guardian-details.component';
import { GuardianListComponent } from "./components/guardian-list/guardian-list.component";
import { GuardianRoutingModule } from "./guardian-routing.module";



@NgModule({
  declarations: [
    GuardianComponent,
    GuardianDetailsComponent,
    GuardianListComponent,
  ],
  imports: [
    CommonModule,
    GuardianRoutingModule
  ]
})
export class GuardianModule { }
