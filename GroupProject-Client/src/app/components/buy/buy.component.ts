import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import {Item} from "../../models/item";
import {ItemService} from "../../services/item.service";
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {
  items: Item[] = [];

  displayedColumns = ['productName', 'description', 'price', 'time', 'action'];
  dataSource: MatTableDataSource<Item>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private itemService: ItemService) {
    // this.getAllSellingItems();
    this.items = [
      {
        itemId: 1,
        sellerId: 1,
        buyerId: 1,
        price: 1,
        productName: "1",
        description: "1",
        status: 1,
        time: new Date()
      },
      {
        itemId: 2,
        sellerId: 2,
        buyerId: 2,
        price: 2,
        productName: "2",
        description: "2",
        status: 2,
        time: new Date()
      }
    ];
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
  getAllSellingItems(): void {

    this.itemService.getAllSellingItems()
      .subscribe( items => {
        this.items = items;
        this.dataSource = new MatTableDataSource(this.items);
      }, error => {
        console.log(error);
      });
  }
  addItemToCart(itemId: number) {
    this.itemService.addItemToCart(itemId)
      .subscribe(() => {
        for (let i = 0; i < this.items.length; i++) {
          if (this.items[i].itemId === itemId) {
            alert(`Added ${this.items[i].productName} to Cart`);
            break;
          }
        }
      }, error => {
        console.log(error);
      });
  }
}
