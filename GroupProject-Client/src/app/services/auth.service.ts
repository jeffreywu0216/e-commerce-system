import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Router} from "@angular/router";

@Injectable()
export class AuthService {
  loginURL = 'http://localhost:8090/ra/login';
  constructor(private http: HttpClient, private router: Router) { }
  login(username: string, password: string) {
    const url = `${this.loginURL}`;
    return this.http.post(url, JSON.stringify({username: username, password: password}));
  }
  logout() {
    localStorage.removeItem('currentUser');
  }
}
