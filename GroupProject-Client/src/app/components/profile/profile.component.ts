import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {User} from "../../models/user";
import {AlertService} from "../../services/alert.service";
import { UserService } from './../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User;

  constructor(private auth: AuthService, private alertService: AlertService, 
    private service: UserService, private router: Router,) { }

  ngOnInit() {
    this.service.findUser(this.auth.getUser().id)
    .subscribe( user => {
      this.user = user;
    });
  }

  editProfile(){
   this.router.navigate(["/edit"]); 
  }

}
