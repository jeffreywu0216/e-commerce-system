import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {User} from "../../models/user";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;

  constructor(private auth: AuthService, private alertService: AlertService) { }

  ngOnInit() {
    this.auth.getUser().subscribe(
      resp => this.user = resp,
      err => this.alertService.error("Error fetching user information")
    );
  }

}
