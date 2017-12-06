import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {CommentComponent} from "../comment/comment.component";
import {MatDialog} from "@angular/material";
import {Item} from "../../models/item";
import {ItemService} from "../../services/item.service";
import {CommentService} from "../../services/comment.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {

  items: Item[] = [];
  comment: string;
  name: string;
  constructor(public dialog: MatDialog, private itemService: ItemService,
              private commService: CommentService, private router: Router) { }
  ngOnInit() {
    this.getLastFourSellingItems();
  }
  openDialog(Id: number): void {
    const dialogRef = this.dialog.open(
      CommentComponent, {
        width: '400px',
        data: {id: Id, comment: this.comment}
      }
    );
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
         console.log(result.id);
         console.log(result.rating.score);
         console.log(result.comment);
        this.commService.submitNewUserReview(result.id, result.comment, result.rating.score).subscribe();
      }
    });
  }
  getLastFourSellingItems(): void {
    this.itemService.getAllSellingItems().subscribe(
      items => {
        this.items = items;
        length = this.items.length;
        this.items = this.items.slice(0, 4);
        console.log(this.items);
      }
    );
  }
  viewItem(id: number) {
    this.router.navigate([`buy/item/${id}`])  ;
  }
}
