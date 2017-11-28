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

    newUser(name:string, email:string, password:string): Observable<any> {
       return this.http.post<User[]>(`http://localhost:8080/user/new/`,
       {
        name:name,
        email: email,
        password: password  
    });
    }
}
