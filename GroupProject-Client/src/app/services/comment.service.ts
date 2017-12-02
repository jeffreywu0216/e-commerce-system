import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Item} from "../models/item";

@Injectable()
export class CommentService {

  constructor(private http: HttpClient) { }
  submitNewReview (itemId: number, review: string): Observable<any> {
    return this.http.post(`http://localhost:8080/reviews/new`, {
        itemId: {itemId: itemId},
        productReview: review
      }
    );
  }
}
