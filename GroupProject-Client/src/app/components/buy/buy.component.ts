import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Item} from "../../models/item";
import {ItemService} from "../../services/item.service";
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {CartService} from "../../services/cart.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit, AfterViewInit {
  items: Item[] = [];

  displayedColumns = ['image', 'productName', 'description', 'price', 'time', 'action'];
  dataSource: MatTableDataSource<Item>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private itemService: ItemService,
              private cartService: CartService,
              private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      const word = params['word'];
      if (word) {
        this.searchResult(word);
      } else {
        this.getAllSellingItems();
      }
      this.dataSource = new MatTableDataSource(this.items);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
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
  searchResult(word: string) {
    this.itemService.getSearchResult(word)
      .subscribe(items => {
        this.items = [];
        this.items = items;
        this.dataSource = new MatTableDataSource(this.items);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, error => {
        console.log(error);
      });
  }
  getAllSellingItems(): void {
    this.itemService.getAllSellingItems()
      .subscribe( items => {
        this.items = [];
        this.items = items;
        this.dataSource = new MatTableDataSource(this.items);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
        console.log(this.items);

      }, error => {
        console.log(error);
      });
  }
  addItemToCart(item: Item) {
    this.cartService.addItemToCart(item)
      .subscribe(() => {
        alert(item.productName + " Added" );
      }, error => {
        console.log(error);
      });
  }
}
