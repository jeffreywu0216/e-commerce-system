import {Component, DoCheck, OnChanges, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements DoCheck {
  isManager: boolean;
  isLoggedIn: boolean;
  constructor(private login: AuthService) { }



  ngDoCheck() {
    if (localStorage.getItem('userlogin') != null) {
      this.isLoggedIn = true;
    } else {
      this.isLoggedIn = false;
    }
    if (localStorage.getItem('isManager') != null) {
      this.isManager = true;
    } else {
      this.isManager = false;
    }
    console.log(this.isLoggedIn);
  }
}
