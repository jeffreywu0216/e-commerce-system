import { Component, OnInit } from '@angular/core';
import {Item} from "../../models/item";
import {ItemService} from "../../services/item.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CartService} from "../../services/cart.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit {
  item = {};
  constructor(private itemService: ItemService,
              private cartService: CartService,
              private auth: AuthService,
              private route: ActivatedRoute,
              private router: Router) {
    this.route.params.subscribe(params => {
      const id = params['id'];
      this.findItem(id);
    });
  }

  ngOnInit() {
  }
  findItem(id: number) {
    this.itemService.findOne(id)
      .subscribe(item => {
        this.item = item;
      }, err => {
        console.log(err);
      });
  }
  addItemToCart(item: Item) {
    if (this.auth.getLogin()) {
      this.cartService.addItemToCart(item)
        .subscribe(() => {
          alert(item.productName + " Added");
          this.router.navigate([`cart`]);
        }, err => {
          console.log(err);
        });
    } else {
      alert("Please Log In First");
      this.router.navigate(['login']);
    }
  }
}
