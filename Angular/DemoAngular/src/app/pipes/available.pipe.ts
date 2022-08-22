import { Pipe, PipeTransform } from '@angular/core';
import {Product} from "../components/stock/product";

@Pipe({
  name: 'available',
  pure: false
})
export class AvailablePipe implements PipeTransform {

  transform(value: Product[], active: boolean = true): Product[] {
    if ( active ) {
      return value.filter( e => e.quantity > 0 );
    }
    return value;
  }

}
