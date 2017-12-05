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


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  constructor(private router: Router, private service: UserService, private alert: AlertService) {}

  model: any = {};

  email = new FormControl('', [Validators.required, Validators.email]);

  passwordControl = new FormControl('', [
    Validators.required,
  ]);
  
    getErrorMessage() {
      return this.email.hasError('required') ? 'You must enter a value' :
          this.email.hasError('email') ? 'Not a valid email' :
              '';
    }

    submitNewUser(){
      console.log(this.model.password);
      this.service.newUser(this.model.name, this.model.email, this.model.password,
         this.model.street, this.model.city, this.model.state, this.model.phone)
      .subscribe(err => {
        this.alert.error("Invalid  Input")
        },
        rsp => {
          this.router.navigate(["login"])
        });
    }
}


