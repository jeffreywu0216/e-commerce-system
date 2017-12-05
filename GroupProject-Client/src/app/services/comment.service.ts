import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Item} from "../models/item";
import {AuthService} from "./auth.service";

@Injectable()
export class CommentService {

  constructor(private http: HttpClient, private auth: AuthService) { }
  submitNewProductReview (itemId: number, review: string, rating: number): Observable<any> {
    return this.http.post(`http://localhost:8080/reviews/new/product`, {
      itemId: {itemId: itemId},
      productReview: review,
      rating: rating
      }
    );
  }
  submitNewUserReview (sellerId: number, review: string, rating: number): Observable<any> {
    return this.http.post(`http://localhost:8080/reviews/new/user`, {
        buyerId: {id: this.auth.getUser().id},
        sellerId: {id: sellerId},
        userReview: review,
        rating: rating
      }
    );
  }
  getUserReview  (sellerId: number): Observable<Comment[]> {
    return this.http.get<Comment[]>(`http://localhost:8080/reviews/buyer/${sellerId}`);
  }
}
