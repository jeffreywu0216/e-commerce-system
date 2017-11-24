import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Router} from "@angular/router";
import {AlertService} from "./alert.service";

@Injectable()
export class AuthService {
  loginURL = 'http://localhost:8080/user/login';
  userlogin = false;
  isAdmin = false;
  constructor(private http: HttpClient, private router: Router, private alertService: AlertService) { }
  login(username: string, password: string) {
    const url = `${this.loginURL}`;
    return this.http.post(url, {email: username, password: password}).subscribe(
      resp => {
        localStorage.setItem('currentUser', JSON.stringify(resp));
        this.userlogin = true;
        if (localStorage.getItem("title") === 'Admin') {
          this.isAdmin = true;
        }
        this.router.navigate(['homepage']);
      },
      err => {
        console.log('login fail');
        this.alertService.error("Invalid Username or Password");
      }
    );
  }
  logout() {
    localStorage.removeItem('currentUser');
    this.userlogin = false;
    this.isAdmin = false;
  }
}
