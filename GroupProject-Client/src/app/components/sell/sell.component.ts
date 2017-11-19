import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
  price: number;
  productName: string;
  description: string;
  constructor() { }

  ngOnInit() {
  }
  submit() {}
}
