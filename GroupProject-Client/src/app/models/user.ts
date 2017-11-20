export interface User {
    id:number;
    name:string;
    age:number;
    email:string;
    password:string;
    phone:number;
    ccard:number;
    address: Address;

    getUser();
}

interface Address{
    street:string;
    city:string;
    state:string;
  }