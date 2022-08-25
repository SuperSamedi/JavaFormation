import { Component, OnInit } from '@angular/core';
import {Guardian} from "../../models/guardian";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../../../../environments/environment";
import {Observable} from "rxjs";
import {Token} from "../../models/token";

@Component({
  selector: 'app-guardian-list',
  templateUrl: './guardian-list.component.html',
  styleUrls: ['./guardian-list.component.css']
})
export class GuardianListComponent implements OnInit {

  private _guardianList: Guardian[] = [];

  get GuardianList(): Guardian[] {return [...this._guardianList]}


  constructor( private _http: HttpClient ) {

  }

  ngOnInit(): void {
    this.getAllGuardians();
  }

  getAllGuardians() {
    const params = new HttpHeaders().append("Authorization", `Bearer ${localStorage.getItem("token")}`)
    this._http.get<Guardian[]>(environment.api.url + "/guardian/all", { headers: params }).subscribe(
      response => {
        console.log(response);
        this._guardianList = response;
      }
    );
  }
}
