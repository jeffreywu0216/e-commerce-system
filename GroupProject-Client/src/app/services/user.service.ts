import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";


import { User } from './../models/user';
import { AuthService } from './auth.service';

@Injectable()
export class UserService {

  constructor(private http: HttpClient,
    private auth: AuthService) { }

    findUser(userId: number): Observable<User> {
      return this.http.get<User>(`http://localhost:8080/user/${userId}`);
    }

    getAllUsers(): Observable<User[]>{
      return this.http.get<User[]>(`http://localhost:8080/user/`);
    }

    newUser(email:string, password:string, street:string, city: string, state:string): Observable<any> {
       return this.http.post<User[]>(`http://localhost:8080/user/new/`,
       {
        email: email,
        password: password, 
        street: street,
        city: city,
        state: state
    });
    }
}
