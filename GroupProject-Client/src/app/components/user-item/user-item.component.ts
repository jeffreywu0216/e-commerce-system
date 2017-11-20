import {Component, OnInit, ViewChild} from '@angular/core';
import {ItemService} from "../../services/item.service";
import {Item} from "../../models/item";
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

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
  constructor(private itemService: ItemService) {
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
  getAllItem() {}
  getAllSellItem() {}
  getAllSoldItem() {}
  viewBuyer() {}
  cancelItem(itemId: number) {} // make a new status for canceled items so can be put back
}
