import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private user$: BehaviorSubject<any | null> = new BehaviorSubject(null);

  get User$(): Observable<any | null> { return this.user$.asObservable(); }


  constructor() {
    const user = localStorage.getItem("user");
    if (user) {
      this.user$.next(user);
    }
  }


  login(user: any) {
    this.user$.next(user);
    localStorage.setItem("user", JSON.stringify(user));
  }

  logout() {
    this.user$.next(null);
    localStorage.removeItem("user");
  }

}
