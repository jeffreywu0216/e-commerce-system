import {AfterViewInit, Component, Inject, OnInit, ViewChild} from '@angular/core';
import {Item} from "../../models/item";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {ItemService} from "../../services/item.service";
import {AuthService} from "../../services/auth.service";
import {User} from "../../models/user";
import {UserService} from "../../services/user.service";
import {CommentComponent} from "../comment/comment.component";
import {CommentService} from "../../services/comment.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit, AfterViewInit {
  items: Item[] = [];
  comment: String;
  displayedColumns = ['image', 'productName', 'price', 'time', 'action'];
  dataSource: MatTableDataSource<Item>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private itemService: ItemService,
              private userService: UserService,
              private auth: AuthService, 
              private commService: CommentService,
              public dialog: MatDialog,
              private router: Router) {
    this.getAllBoughtItemsByBuyerId();
    this.dataSource = new MatTableDataSource(this.items);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  ngOnInit() {
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
  getAllBoughtItemsByBuyerId(): void {
    this.itemService.getAllBoughtItemsByBuyerId(this.auth.getUser().id)
      .subscribe( items => {
        this.items = items;
        this.dataSource = new MatTableDataSource(this.items);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, error => {
        console.log(error);
      });
  }
  viewSeller(sellerId: number) {
    this.userService.findUser(sellerId)
      .subscribe(user => {
        this.openViewSellerDialog(user);
      }, err => {
        console.log(err);
      });
  }
  openReviewDialog(id: number, sender: number): void {
    const dialogRef = this.dialog.open(
      CommentComponent, {
        width: '400px',
        data: {id: id, comment: this.comment}
      }
    );
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log(result.id);
        console.log(result.rating.score);
        console.log(result.comment);
        if (sender === 1) {
          this.commService.submitNewProductReview(result.id, result.comment, result.rating.score).subscribe();
        } else if (sender === 2) {
          this.commService.submitNewUserReview(result.id, result.comment, result.rating.score).subscribe();

        }
      }
    });
  }
  openViewSellerDialog(user: User): void {
    const dialogRef = this.dialog.open(OrderHistoryViewSellerDialogComponent, {
      width: '250px',
      data: {
        email: user.email,
        phone: user.phone
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // this.animal = result;
    });
  }
  viewDetail(itemId: number) {
    this.router.navigate([`buy/item/${itemId}`]);
  }
}

@Component({
  selector: 'app-order-history-view-seller-dialog',
  templateUrl: './order-history-view-seller-dialog.component.html',
})
export class OrderHistoryViewSellerDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<OrderHistoryViewSellerDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
