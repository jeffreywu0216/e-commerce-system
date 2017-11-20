import { Component, OnInit } from '@angular/core';
import { User } from './../../models/user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
 submitted = false;
 
  constructor() { }

  ngOnInit() {
    
  }

  onSubmit(){this.submitted = true;}
  

}
