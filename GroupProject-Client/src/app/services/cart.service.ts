import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Item} from "../models/item";
import {Observable} from "rxjs/Observable";
import {AuthService} from "./auth.service";

@Injectable()
export class CartService {

  constructor(private http: HttpClient,
              private auth: AuthService) { }

  getAllCartByBuyerId(buyerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/cart/buyer/${buyerId}`);
  }
  addItemToCart(item: Item): Observable<any> {
    return this.http.post(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/cart/watch-item/${this.auth.getUser().id}`,
      {itemId: item.itemId}
    );
  }
  removeItemFromCart(itemId: number) {
    return this.http.post(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/cart/unwatch-item/${this.auth.getUser().id}`,
      {
        itemId: itemId
      }
    );
  }
  buyItems(buyerId: number): Observable<any> {
    return this.http.post(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/cart/purchase`, {buyerId: {id: buyerId}});
  }
}
