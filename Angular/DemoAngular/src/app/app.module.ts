import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from "@angular/forms";
import { StockComponent } from './components/stock/stock.component';
import { AvailablePipe } from './pipes/available.pipe';
import { PricePipe } from './pipes/price.pipe';
import { AppRoutingModule } from "./app-routing.module";
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { ParityComponent } from './components/parity/parity.component';
import { ContactComponent } from './components/contact/contact.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    StockComponent,
    AvailablePipe,
    PricePipe,
    LandingPageComponent,
    ParityComponent,
    ContactComponent,
    ProductDetailsComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
