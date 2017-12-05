import { Component, OnInit } from '@angular/core';
import {ItemService} from "../../services/item.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
  imgFile: string;
  pictureUrl: string;
  price: number;
  productName: string;
  description: string;

  // aws_access_key = 'AKIAJCJVDFNS4RVYZC6Q';
  // aws_secret_key = '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';
  // bucket = 'jeffrey-wu-test'; // the name you've chosen for the bucket
  // key = `users/${this.auth.getUser().id}/${this.imgFile.name}`;
  // success_action_redirect = 'http://localhost:8080/sell';
  // content_type = 'image/';
  // acl = 'public-read';
  //
  // year = new Date();
  // policy = { expiration: `${this.year.getFullYear() + 10}`,
  //   conditions: [
  //     {bucket: `${this.bucket}`},
  //     ["starts-with", "$key", "'.str_replace('${filename}', '', $key).'"],
  //     {"acl": "'.$acl.'"},
  //     {"success_action_redirect": "'.$success_action_redirect.'"},
  //     ["starts-with", "$Content-Type", "'.$content_type.'"],
  //     {"x-amz-meta-uuid": "14365123651274"},
  //     ["starts-with", "$x-amz-meta-tag", ""]
  //     ]
  // };
  constructor(private itemService: ItemService,
              public auth: AuthService) { }

  ngOnInit() {
  }
  submitNewSellItem() {
    this.itemService.submitNewSellItem(this.price, this.productName, this.description, this.pictureUrl, this.imgFile)
      .subscribe(() => {
        alert("Success!");
        this.price = undefined;
        this.productName = undefined;
        this.description = undefined;
        this.imgFile = undefined;
      }, err => {
        alert('Fail');
        console.log(err);
      });
  }

  getImg(e): void {
    this.readThis(e.target);
  }

  readThis(inputValue: any): void {
    const file: File = inputValue.files[0];
    this.pictureUrl = file.name;
    this.pictureUrl = this.pictureUrl.trim();
    this.pictureUrl = this.pictureUrl.replace(/[^\w]/gi, '');
    // this.pictureUrl = this.pictureUrl.split(' ').join('');
    // this.pictureUrl = this.pictureUrl.split('%').join('');
    // this.pictureUrl = this.pictureUrl.split('\\').join('');
    // this.pictureUrl = this.pictureUrl.split('#').join('');
    // this.pictureUrl = this.pictureUrl.split('/').join('');
    // this.pictureUrl = this.pictureUrl.split('!').join('');
    // this.pictureUrl = this.pictureUrl.split('&').join('');

    const myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.imgFile = myReader.result;
    },
    myReader.readAsDataURL(file);
  }
}
