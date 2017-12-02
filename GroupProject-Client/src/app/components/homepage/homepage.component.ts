import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {CommentComponent} from "../comment/comment.component";
import {MatDialog} from "@angular/material";
import {Item} from "../../models/item";
import {ItemService} from "../../services/item.service";
import {CommentService} from "../../services/comment.service";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {

  items: Item[] = [];
  comment: string;
  name: string;
  constructor(public dialog: MatDialog, private itemService: ItemService, private commService: CommentService) { }
  ngOnInit() {
    this.getLastFourSellingItems();
  }
  openDialog(itemsId: number): void {
    const dialogRef = this.dialog.open(
      CommentComponent, {
        width: '400px',
        data: {id: itemsId, comment: this.comment}
      }
    );
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      if (result) {
        this.commService.submitNewReview(itemsId, result).subscribe();
      }
    });
  }
  getLastFourSellingItems(): void {
    this.itemService.getAllSellingItems().subscribe(
      items => {
        this.items = items;
        length = this.items.length;
        this.items = this.items.slice(length - 4, length);
        console.log(this.items);
      }
    );
  }

}
