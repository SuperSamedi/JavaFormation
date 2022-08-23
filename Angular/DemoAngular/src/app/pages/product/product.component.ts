import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  // $ -> convention de Flavian
  constructor(private $http: HttpClient) { }

  ngOnInit(): void {
    const params = new HttpHeaders().append("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJGcm9kbyIsInJvbGVzIjpbIlJPTEVfUEVSU09OTkVMIl0sImV4cCI6MTY2MjA5MjkyMn0.wp58Ak7dJMjkQZta4suLykjxNLi8-9XzAKjJt_cV0ayxQjr1dEr_XEFW2m2z3_ezG5tqZ1k7ba2BjFrhFGuMjQ");
    this.$http.get(environment.api.url + "/child/all", {headers: params}).subscribe();
  }

}
