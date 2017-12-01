import {AfterViewInit, Component, Inject, OnInit, ViewChild} from '@angular/core';
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
export class UserItemComponent implements OnInit, AfterViewInit {
  items: Item[];
  selected = "option1";
  displayedColumns = ['image', 'productName', 'description', 'price', 'time', 'action'];
  dataSource: MatTableDataSource<Item>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private itemService: ItemService,
              private userService: UserService,
              private authService: AuthService,
              public dialog: MatDialog) {
  }

  ngOnInit() {
    this.getAllItem();
    this.dataSource = new MatTableDataSource(this.items);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
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
        this.items = [];
        this.items = items;
        this.dataSource = new MatTableDataSource(this.items);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, err => {
        console.log(err);
      });
  }
  getAllSellItem() {
    this.itemService.getAllSellItemsBySellerId(this.authService.getUser().id)
      .subscribe( items => {
        this.items = [];
        this.items = items;
        this.dataSource = new MatTableDataSource(this.items);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, err => {
        console.log(err);
      });
  }
  getAllSoldItem() {
    this.itemService.getAllSoldItemsBySellerId(this.authService.getUser().id)
      .subscribe( items => {
        this.items = [];
        this.items = items;
        this.dataSource = new MatTableDataSource(this.items);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, err => {
        console.log(err);
      });
  }
  viewBuyer(buyerId: number) {
    this.userService.findUser(buyerId)
      .subscribe(user => {
        this.openViewBuyerDialog(user);
      }, err => {
        console.log(err);
      });
  }
  updateItem(item: Item) {
    this.itemService.updateSellItem(item)
      .subscribe(() => {
        alert("Success");
        this.getAllItem();
      }, err => {
        console.log(err);
      });
  }
  cancelItem(itemId: number): void {
    this.itemService.removeSellItem(itemId)
      .subscribe(() => {
        console.log("Success");
        this.getAllItem();
      }, err => {
        console.log(err);
      });
  }
  openViewBuyerDialog(user: User): void {
    const dialogRef = this.dialog.open(UserItemViewBuyerDialogComponent, {
      width: '250px',
      data: {
        email: user.email,
        street: user.street,
        city: user.city,
        state: user.state,
        phone: user.phone
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
  openUpdateDialog(item: Item): void {
    const dialogRef = this.dialog.open(UserItemUpdateDialogComponent, {
      width: '250px',
      data: {
        item: item
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      if (result) {
        this.updateItem(result);
      }
    });
  }
  openCancelDialog(item: Item): void {
    const dialogRef = this.dialog.open(UserItemCancelDialogComponent, {
      width: '250px',
      data: {
        productName: item.productName,
        itemId: item.itemId
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.cancelItem(result);
      }
    });
  }
}

@Component({
  selector: 'app-user-item-view-buyer-dialog',
  templateUrl: './user-item-view-buyer-dialog.component.html',
})
export class UserItemViewBuyerDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<UserItemViewBuyerDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

@Component({
  selector: 'app-user-item-update-dialog',
  templateUrl: './user-item-update-dialog.component.html',
})
export class UserItemUpdateDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<UserItemUpdateDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

@Component({
  selector: 'app-user-item-cancel-dialog',
  templateUrl: './user-item-cancel-dialog.component.html',
})
export class UserItemCancelDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<UserItemCancelDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
