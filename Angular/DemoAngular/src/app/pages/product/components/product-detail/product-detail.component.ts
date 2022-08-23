import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Product} from "../../../../components/stock/product";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  stock: Product[] = [
    {
      id: 1,
      name: "Krabby Patty",
      description: "The yummy classic!",
      image: "https://64.media.tumblr.com/b468a40070cac271b3bbd482447f5465/tumblr_p1y9cz3xce1vqc713o1_500.gif",
      price: 4.99,
      quantity: 42
    },
    {
      id: 2,
      name: "Kelp Shake",
      description: " The freshest in the whole sea.",
      image: "https://static.wikia.nocookie.net/spongebob/images/0/05/Best_Frenemies_012.png",
      price: 1.49,
      quantity: 6
    },
    {
      id: 3,
      name: "Kelp Fries",
      description: "Next level Krustiness.",
      image: "http://en.spongepedia.org/images/c/c1/130a_Kelp_Fries.jpg",
      price: 2,
      quantity: 3
    },
    {
      id: 4,
      name: "The Triple Gooberberry",
      description: "Don't you dare.",
      image: "https://static.wikia.nocookie.net/spongebob/images/6/6c/Goofy-goober-sundae.jpg",
      price: 3.99,
      quantity: 4
    },
    {
      id: 5,
      name: "Krusty Kid's Meal",
      description: "The surprise is worth it, we swear...",
      image: "https://static.wikia.nocookie.net/spongebob/images/5/5b/Yours%2C_Mine_and_Mine_014.png",
      price: 14.99,
      quantity: 5
    },
    // {
    //   id: 6,
    //   name: "Krabby Patty",
    //   description: "The yummy classic!",
    //   image: "https://64.media.tumblr.com/b468a40070cac271b3bbd482447f5465/tumblr_p1y9cz3xce1vqc713o1_500.gif",
    //   price: 4.99,
    //   quantity: 42
    // }
  ]
  private product: any = null;

  get Product(): any {return this.product;}

  constructor(private route: ActivatedRoute) {
    this.route.paramMap.subscribe((params) => {
      const idParam = params.get("id");
      if (idParam) {
        const id = parseInt(idParam);
        this.product = this.stock.find(p => p.id)
      }
    })
  }

  ngOnInit(): void { }

}
