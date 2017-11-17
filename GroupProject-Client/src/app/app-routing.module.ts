import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";

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
