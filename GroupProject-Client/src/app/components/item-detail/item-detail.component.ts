import {Component, OnInit, ViewChild, AfterViewInit} from '@angular/core';
import {Item} from "../../models/item";
import {ItemService} from "../../services/item.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CartService} from "../../services/cart.service";
import {AuthService} from "../../services/auth.service";
import {CommentService} from "../../services/comment.service";
import {MatSort, MatTableDataSource} from "@angular/material";

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.css']
})
export class ItemDetailComponent implements OnInit, AfterViewInit {
  item: Item;
  comment: Comment[] = [];
  displayedColumns = ['comment', 'rating'];
  dataSource: MatTableDataSource<Comment>;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private itemService: ItemService,
              private cartService: CartService,
              private commService: CommentService,
              private auth: AuthService,
              private route: ActivatedRoute,
              private router: Router) {
    this.dataSource = new MatTableDataSource(this.comment);

    this.route.params.subscribe(params => {
      const id = params['id'];
      this.findItem(id);
    });
  }

  ngOnInit() {
  }
  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }
  findItem(id: number) {
    this.itemService.findOne(id)
      .subscribe(item => {
        this.item = item;
        this.findComment(item.sellerId.id);
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
  findComment(itemId: number) {
    this.commService.getUserReview(itemId).subscribe(
      comm => {
        this.comment = comm;
        this.dataSource = new MatTableDataSource(this.comment);
      }, err => {
        console.log(err);
      }
    );
  }
}
