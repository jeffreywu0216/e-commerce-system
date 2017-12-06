import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Item} from "../models/item";
import {AuthService} from "./auth.service";
import {it} from "selenium-webdriver/testing";

@Injectable()
export class ItemService {

  constructor(private http: HttpClient,
              private auth: AuthService) { }
  findOne(itemId: number): Observable<Item> {
    return this.http.get<Item>(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/item/${itemId}`);
  }
  getAllSellingItems(): Observable<Item[]> {
    return this.http.get<Item[]>(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items`);
  }
  getSearchResult(word: string): Observable<Item[]> {
    return this.http.get<Item[]>(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/search/${word}`);
  }
  getAllItemsBySellerId(sellerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/seller/${sellerId}`);
  }
  getAllSellItemsBySellerId(sellerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/seller/sell/${sellerId}`);
  }
  getAllSoldItemsBySellerId(sellerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/seller/sold/${sellerId}`);
  }
  getAllBoughtItemsByBuyerId(buyerId: number): Observable<Item[]> {
    return this.http.get<Item[]>(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/buyer/bought/${buyerId}`);
  }
  submitNewSellItem  (price: number, productName: string, description: string, pictureUrl: string, picture: string): Observable<any> {
    return this.http.post(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/item/new/${this.auth.getUser().id}`,
      {
        price: price,
        productName: productName,
        description: description,
        pictureUrl: pictureUrl,
        picture: picture
      });
  }
  updateSellItem(item: Item) {
    return this.http.post(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/item/update/${item.itemId}`,
      {
        sellerId: item.sellerId,
        price: item.price,
        productName: item.productName,
        description: item.description,
        pictureUrl: item.pictureUrl
      });
  }
  removeSellItem(itemId: number) {
    return this.http.post(`http://ec2-54-82-250-157.compute-1.amazonaws.com:8080/items/item/delete`,
      {
        itemId: itemId
      });
  }

}
