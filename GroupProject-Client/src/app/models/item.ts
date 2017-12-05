import {User} from "./user";

export interface Item {
  itemId: number;
  sellerId: User;
  buyerId: User;
  price: number;
  productName: string;
  description: string;
  statusId: number;
  timeToSell: string;
  pictureUrl: string;
}
