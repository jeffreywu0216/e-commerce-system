import { Component, OnInit } from '@angular/core';
import {Item} from "../../models/item";
import {ItemService} from "../../services/item.service";

@Component({
  selector: 'app-sell-item-form',
  templateUrl: './sell-item-form.component.html',
  styleUrls: ['./sell-item-form.component.css']
})
export class SellItemFormComponent implements OnInit {
  items: Item[];
  constructor(private itemService: ItemService) { }

  ngOnInit() {
    this.getAllItem();
  }
  getAllItem() {}
  getAllSellItem() {}
  getAllSoldItem() {}
  viewBuyer() {}
  cancelItem() {} // make a new status for canceled items so can be put back
}
