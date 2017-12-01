import { Component, OnInit } from '@angular/core';
import {ItemService} from "../../services/item.service";
import {MatTableDataSource, MatSort} from '@angular/material';
import {Item} from "../../models/item";
import {CartService} from "../../services/cart.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  items: Item[] = [];

  displayedColumns = ['image', 'productName', 'description', 'price', 'action'];
  dataSource: MatTableDataSource<Item>;
  constructor(private itemService: ItemService,
              private cartService: CartService,
              private auth: AuthService) {
    this.getAllCartByBuyerId();
    this.dataSource = new MatTableDataSource(this.items);
  }

  ngOnInit() {
  }
  getAllCartByBuyerId() {
    this.cartService.getAllCartByBuyerId(this.auth.getUser().id)
      .subscribe( cart => {
        for (let i = 0; i < cart.length; i++) {
          this.itemService.findOne(cart[i].itemId)
            .subscribe( item => {
              this.items[i] = item;
              this.dataSource = new MatTableDataSource(this.items);
            }, err => {
                console.log(err);
            });
        }
      }, err => {
        console.log(err);
      });
  }

  // call strip api, and after success link to database
  buyItems(userId: number) {
    this.cartService.buyItems(this.auth.getUser().id)
      .subscribe(() => {
        alert("Success");
      }, error => {
        console.log(error);
      });
  }
  removeItemFromCart(itemId: number, productName: string) {
    this.cartService.removeItemFromCart(itemId)
      .subscribe(resp => {
        this.items = [];
        this.dataSource = new MatTableDataSource(this.items);
        this.getAllCartByBuyerId();
        alert(`${resp}, Removed ${productName} from cart`);
      }, error => {
        console.log(error);
      });
  }
}
