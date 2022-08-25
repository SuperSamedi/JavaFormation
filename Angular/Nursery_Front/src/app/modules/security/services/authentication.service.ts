import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private _http: HttpClient) { }

  loginCall(username: string, password: string): Observable<any> {
    // const params = new HttpParams({fromObject: {username, password}});
    return this._http.post(environment.api.url + "/account/login", {username: username, password: password});
  }
}
