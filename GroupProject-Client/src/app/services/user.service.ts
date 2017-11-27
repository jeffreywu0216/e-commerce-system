import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

import { User } from './../models/user';

@Injectable()
export class UserService {

  constructor(private http: HttpClient,
    private auth: AuthService) { }

    findUser(userId: number): Observable<User> {
      return this.http.get<User>(`http://localhost:8080/users/user/${userId}`);
    }

    getAllUsers(): Observable<User[]>{
      return this.http.get<User[]>(`http://localhost:8080/users/`);
    }

    newUser(email:any, password:string): Observable<any> {
       return this.http.post<User[]>(`http://localhost:8080/users/user/new/${this.auth.id}`,
       JSON.stringify({
        email: email,
        password: password,
       
    }));
    }
}
