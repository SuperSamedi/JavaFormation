import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-even',
  templateUrl: './parity.component.html',
  styleUrls: ['./parity.component.css'] })
export class ParityComponent implements OnInit {

  // route!: ActivatedRoute;
  nbr: number;

  // Ajouter un modificateur d'acces sur le parametre, il devient une variable d'instance.
  constructor(private route: ActivatedRoute) {
    // this.route = route;
    this.nbr = route.snapshot.params['nbr'];
  }

  ngOnInit(): void {
  }

}
