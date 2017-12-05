import {User} from "./user";

export interface Comment {
  id: number;
  sellerId: User;
  buyerId: User;
  userReview: string;
  rating: number;
}
