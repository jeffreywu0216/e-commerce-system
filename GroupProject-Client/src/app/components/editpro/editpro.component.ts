import {Component, OnInit} from '@angular/core';
import {User} from './../../models/user';
import {FormControl, Validators} from '@angular/forms';
import {FocusMonitor} from '@angular/cdk/a11y';
import {coerceBooleanProperty} from '@angular/cdk/coercion';
import {ElementRef, Input, OnDestroy} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {MatFormFieldControl} from '@angular/material/form-field';
import {Subject} from 'rxjs/Subject';
import {MatDatepickerModule} from '@angular/material/datepicker';

import { UserService } from './../../services/user.service';
import { AlertService } from './../../services/alert.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'edit',
  templateUrl: './editpro.component.html',
  styleUrls: ['./editpro.component.css']
})
export class EditproComponent implements OnInit {
constructor(private router: Router, private service: UserService, private alert: AlertService,
private location: Location){
  }
  model: any = {};

  ngOnInit() {
    // console.log(this.model.name);
  }
  
  cancel(){
    this.location.back();
  }

  updateUser(){
    console.log(this.model.password);
      this.service.newUser(this.model.name, this.model.email, this.model.password,
         this.model.street, this.model.city, this.model.state, this.model.phone)
          .subscribe(err => { this.alert.error("Invalid  Input")},
            rsp => {this.router.navigate(["profile"])});
    }
}


