export class UserModel {
    constructor(
        private id:number,
        private name:string,
        private age:number,
        private email:string,
        private password:string,
        private phone:string,
        private ccard:string,
        private address: Address
      ) {  }
}
interface Address{
    street:string;
    city:string;
    state:string;
  }