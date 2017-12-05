import {Item} from "./item";

export interface Comment {
  id: number;
  itemId: Item;
  review: string;
  rating: number;
}
