import { Component, OnInit } from '@angular/core';
import {ItemService} from "../../services/item.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private itemService: ItemService) {
  }

  ngOnInit() {
  }

  // call strip api, and after success link to database
  buyItem(userId: number) {
    // this.itemService.buyItem()
    //   .subscribe(() => {
    //   }, error => {
    //     console.log(error);
    //   });
  }
  removeItemFromCart(itemId: number) {
    this.itemService.removeItemFromCart(itemId)
      .subscribe(() => {
      }, error => {
        console.log(error);
      });
  }
}
