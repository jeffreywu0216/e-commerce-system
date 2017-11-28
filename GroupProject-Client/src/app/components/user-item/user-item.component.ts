import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {ItemService} from "../../services/item.service";
import {Item} from "../../models/item";
import {MatPaginator, MatSort, MatTableDataSource, MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {UserService} from "../../services/user.service";
import {AuthService} from "../../services/auth.service";
import {User} from "../../models/user";

@Component({
  selector: 'app-user-item',
  templateUrl: './user-item.component.html',
  styleUrls: ['./user-item.component.css']
})
export class UserItemComponent implements OnInit {
  items: Item[];
  selected = "option1";
  displayedColumns = ['productName', 'description', 'price', 'time', 'action'];
  dataSource: MatTableDataSource<Item>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private itemService: ItemService,
              private userService: UserService,
              private authService: AuthService,
              public dialog: MatDialog) {
    this.getAllItem();
    this.dataSource = new MatTableDataSource(this.items);
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
  getAllItem() {
    this.itemService.getAllItemsBySellerId(this.authService.getUser().id)
      .subscribe( items => {
        this.items = items;
      }, err => {
        console.log(err);
      });
  }
  getAllSellItem() {
    this.itemService.getAllSellItemsBySellerId(this.authService.getUser().id)
      .subscribe( items => {
        this.items = items;
      }, err => {
        console.log(err);
      });
  }
  getAllSoldItem() {
    this.itemService.getAllSoldItemsBySellerId(this.authService.getUser().id)
      .subscribe( items => {
        this.items = items;
      }, err => {
        console.log(err);
      });
  }
  // viewBuyer(buyerId: number) {
  //   this.userService.getUser()
  // }
  // updateItem(itemId: number) {}
  // cancelItem(itemId: number) {
  //   this.itemService.removeSellItem()
  // } // make a new status for canceled items so can be put back
  //
  // openViewBuyerDialog(buyerId: number): void {
  //   let user: User;
  //   this.userService.getUser(buyerId)
  //     .subscribe(resp => {
  //       user = resp;
  //     }, err => {
  //       console.log(err);
  //     })
  //   const dialogRef = this.dialog.open(UserItemDialogComponent, {
  //     width: '250px',
  //     data: {
  //       email: user.email,
  //       street: user.street,
  //       city: user.city,
  //       state: user.state,
  //       phone: user.phone
  //     }
  //   });

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('The dialog was closed');
    //   this.animal = result;
    // });
  // }
}

@Component({
  selector: 'app-user-item-dialog',
  templateUrl: './user-item-dialog.component.html',
})
export class UserItemDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<UserItemDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
