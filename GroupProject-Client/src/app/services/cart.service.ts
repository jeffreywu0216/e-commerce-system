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
    return this.http.get<Item[]>(`http://localhost:8080/cart/buyer/${buyerId}`);
  }
  addItemToCart(item: Item): Observable<any> {
    return this.http.post(`http://localhost:8080/cart/watch-item/${this.auth.getUser().id}`,
      JSON.stringify({item: item})
    );
  }
  removeItemFromCart(shoppingCartId: number) {
    return this.http.post(`http://localhost:8080/cart/unwatch-item/${this.auth.getUser().id}`,
      JSON.stringify({shoppingCartId: shoppingCartId})
    );
  }
  buyItems(buyerId: number): Observable<any> {
    return this.http.post(`http://localhost:8080/cart/purchase`,
      JSON.stringify({userId: buyerId})
    );
  }
}
