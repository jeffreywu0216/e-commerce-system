import { Component, OnInit } from '@angular/core';
import {ItemService} from "../../services/item.service";

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
  price: number;
  productName: string;
  description: string;
  constructor(private itemService: ItemService) { }

  ngOnInit() {
  }
  submitNewSellItem() {
    this.itemService.submitNewSellItem(this.price, this.productName, this.description)
      .subscribe(() => alert("Success!"), err => alert(err));
  }
}
