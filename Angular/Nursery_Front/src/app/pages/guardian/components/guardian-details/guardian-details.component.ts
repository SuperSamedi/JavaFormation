import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { GuardianListComponent } from "../guardian-list/guardian-list.component";
import {HttpClient, HttpEvent, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Guardian} from "../../models/guardian";
import {environment} from "../../../../../environments/environment";

@Component({
  selector: 'app-guardian-details',
  templateUrl: './guardian-details.component.html',
  styleUrls: ['./guardian-details.component.css']
})
export class GuardianDetailsComponent implements OnInit {

  private getOne$: Observable<Guardian> | null = null;
  private _guardian: Guardian | null = null;
  get Guardian(): Guardian | null { return this._guardian; }

  constructor(private _http: HttpClient, private _route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getOneGuardian();
  }

  getOneGuardian() {
    const params = new HttpHeaders().append("Authorization", `Bearer ${localStorage.getItem("token")}`)
    this._route.paramMap.subscribe( map => {
      this.getOne$ = this._http.get<Guardian>( environment.api.url + `/guardian/${map.get("id")}`, { headers: params } )
      this.getOne$.subscribe(g => this._guardian = g);
    })

  }

}
