import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { StockComponent } from "./components/stock/stock.component";
import { FirstComponent } from "./components/first/first.component";
import { LandingPageComponent } from "./components/landing-page/landing-page.component";
import { ParityComponent } from "./components/parity/parity.component";
import { ContactComponent } from "./components/contact/contact.component";
import { ProductDetailsComponent } from "./components/product-details/product-details.component";

const routes: Routes = [
  { path: '', component: LandingPageComponent },
  { path: 'krusty-krab', component: StockComponent },
  { path: 'demo', component: FirstComponent },
  { path: 'parity/:nbr', component: ParityComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'product/:nbr', component: ProductDetailsComponent },
  { path: 'products', loadChildren: () => import("./pages/product/product.module").then(m => m.ProductModule) }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {



}
