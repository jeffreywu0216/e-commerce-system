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
  total: number;
  handler: any;

  displayedColumns = ['image', 'productName', 'description', 'price', 'action'];
  dataSource: MatTableDataSource<Item>;
  constructor(private itemService: ItemService,
              private cartService: CartService,
              private auth: AuthService) {
    this.getAllCartByBuyerId();
    this.dataSource = new MatTableDataSource(this.items);
  }

  ngOnInit() {
    this.handler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_C44Nfz5X8RSueDEW91uKYvTl',
      locale: 'auto',
      token: token => {
        this.buyItems();
      }
    });
  }
  getAllCartByBuyerId() {
    this.total = 0;
    this.items = [];
    this.dataSource = new MatTableDataSource(this.items);
    this.cartService.getAllCartByBuyerId(this.auth.getUser().id)
      .subscribe( cart => {
        this.dataSource = new MatTableDataSource(cart);
        // for (let i = 0; i < cart.length; i++) {
        //   this.itemService.findOne(cart[i].itemId)
        //     .subscribe( item => {
        //       this.items[i] = item;
        //       this.total = this.total + item.price;
        //       this.dataSource = new MatTableDataSource(this.items);
        //     }, err => {
        //         console.log(err);
        //     });
        // }
      }, err => {
        console.log(err);
      });
  }

  // call strip api, and after success link to database
  buyItems() {
    this.cartService.buyItems(this.auth.getUser().id)
      .subscribe(() => {
        alert("Success");
        this.getAllCartByBuyerId();
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

  openCheckout() {
    // const handler = (<any>window).StripeCheckout.configure({
    //   key: 'pk_test_C44Nfz5X8RSueDEW91uKYvTl',
    //   locale: 'auto',
    //   token: function (token: any) {
    //     // You can access the token ID with `token.id`.
    //     // Get the token ID to your server-side code for use.
    //   }
    // });

    this.handler.open({
      // name: 'Demo Site',
      // description: '2 widgets',
      amount: this.total * 100
    });
  }
}
