import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Item} from "../models/item";

@Injectable()
export class ItemService {

  constructor(private http: HttpClient) { }
  findOne(itemId: number): Observable<Item> {
    return this.http.get<Item>(`http://localhost:8080/items/${itemId}`);
  }
  getAllSellingItems(): Observable<Item[]> {
    return this.http.get<Item[]>(`http://localhost:8080/items`);
  }
  getSearchResult(word: string): Observable<Item[]> {
    const params = new HttpParams().set('word', word);
    return this.http.get<Item[]>(`http://localhost:8080/items/search`, {params: params});
  }
  getAllItemsBySellerId(sellerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://localhost:8080/items/seller/${sellerId}`);
  }
  getAllSellingItemsBySellerId(sellerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://localhost:8080/items/seller/sell/${sellerId}`);
  }
  getAllSoldItemsBySellerId(sellerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://localhost:8080/items/seller/sold/${sellerId}`);
  }
  getAllBoughtItemsByBuyerId(buyerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://localhost:8080/items/buyer/bought/${buyerId}`);
  }
  getAllCartByBuyerId(buyerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://localhost:8080/items/buyer/cart/${buyerId}`);
  }

  submitNewSellItem  (price: number, productName: string, description: string): Observable<any> {
    return this.http.post(`http://localhost:8080/items/new-item/${localStorage.getItem("currentUser")/*.userId*/}`,
      JSON.stringify({
        price: price,
        productName: productName,
        description: description
    }));
  }
  addItemToCart(itemId: number): Observable<any> {
    return this.http.post(`http://localhost:8080/items/watch-item/${localStorage.getItem("currentUser")/*.userId*/}`,
      JSON.stringify({itemId: itemId})
    );
  }
  removeItemFromCart(itemId: number) {
    return this.http.post(`http://localhost:8080/items/unwatch-item/${localStorage.getItem("currentUser")/*.userId*/}`,
      JSON.stringify({itemId: itemId})
    );
  }
  buyItems(): Observable<any> {
    return this.http.put(`http://localhost:8080/items/purchase`,
      JSON.stringify({userId: localStorage.getItem("currentUser")/*.userId*/}));
  }
}
