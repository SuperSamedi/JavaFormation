import { Pipe, PipeTransform } from '@angular/core';
import {Product} from "../components/stock/product";

@Pipe({
  name: 'price'
})
export class PricePipe implements PipeTransform {

  transform(value: Product[], min?: number, max?: number): Product[] {
    return value.filter( p => (!min || p.price >= min) && (!max || p.price <= max) );
  }

}
