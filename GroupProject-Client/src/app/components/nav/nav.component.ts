import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  manager = true;
  navlinks = [{path: 'buy', label: 'Buy'}, {path: 'sell', label: 'Sell'},
    {path: 'profile', label: 'Profile'}];
  navlinks2 = [{path: 'cart', label: 'Cart'},
    {path: 'logout', label: 'Logout'}];
  constructor() { }

  ngOnInit() {
  }

}
