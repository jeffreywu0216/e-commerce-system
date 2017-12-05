import {Component, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {UserService} from "../../services/user.service";
import { User } from "../../models/user";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  users: User[] = [];
  displayedColumns = ['name', 'email', 'phone', 'address'];
  dataSource: MatTableDataSource<User>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  constructor(private userService: UserService) {
    this.getAllUsers();
    this.dataSource = new MatTableDataSource(this.users);
  }

  getAllUsers() {
    this.userService.getAllUsers()
      .subscribe( users => {
        this.users = users;
        this.dataSource = new MatTableDataSource(this.users);
        this.dataSource = new MatTableDataSource(this.users);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }, err => {
        console.log(err);
      });
  }
  
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); 
    filterValue = filterValue.toLowerCase(); 
    this.dataSource.filter = filterValue;
  }
}

