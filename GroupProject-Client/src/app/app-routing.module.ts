import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HomepageComponent} from "./component/homepage/homepage.component";
import {EmployeeComponent} from "./component/employee/employee.component";
import {ReimbursementComponent} from "./component/reimbursement/reimbursement.component";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./component/login/login.component";
import {ProfileComponent} from "./component/profile/profile.component";
import {UpdateInfoComponent} from "./component/update-info/update-info.component";

const routes: Routes = [
  // {path: 'home', component: HomepageComponent},
  // {path: 'employee', component: EmployeeComponent},
  // {path: 'reimbursement', component: ReimbursementComponent},
  // {path: 'reimbursement/:id', component: ReimbursementComponent},
  // {path: 'profile', component: ProfileComponent},
  // {path: 'update-info', component: UpdateInfoComponent},
  // {path: 'login', component: LoginComponent},
  // {path: '', redirectTo: '/', pathMatch: 'full'}
];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule { }
