import { Component, OnInit } from '@angular/core';
import {ItemService} from "../../services/item.service";

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
  imgFile: any;
  price: number;
  productName: string;
  description: string;
  constructor(private itemService: ItemService) { }

  ngOnInit() {
  }
  submitNewSellItem() {
    this.itemService.submitNewSellItem(this.price, this.productName, this.description, this.imgFile.name)
      .subscribe(() => {
        alert("Success!");
        this.price = undefined;
        this.productName = undefined;
        this.description = undefined;
        this.imgFile = undefined;
      }, err => {
        alert(err);
      });
  }

  getImg(evt) {
    this.imgFile = evt.target.files[0];
  }
}
