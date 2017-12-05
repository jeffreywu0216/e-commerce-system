import {Item} from "./item";
import {User} from "./user";

export interface ShoppingCart {
  shoppingCartId: number;
  buyerId: User;
  itemId: Item;
}
