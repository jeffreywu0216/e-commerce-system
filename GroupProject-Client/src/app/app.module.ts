import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './/app-routing.module';
import { FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HttpClientModule} from "@angular/common/http";
import {MatInputModule, MatTabsModule} from "@angular/material";
import { BrowserAnimationsModule} from "@angular/platform-browser/animations";

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavComponent } from './components/nav/nav.component';
import { SearchPipe } from './pipes/search.pipe';
import { SignupComponent } from './components/signup/signup.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AdminComponent } from './components/admin/admin.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { CartComponent } from './components/cart/cart.component';
import { BuyComponent } from './components/buy/buy.component';
import { SellComponent } from './components/sell/sell.component';
import { AlertComponent } from './components/alert/alert.component';
import {AuthService} from "./services/auth.service";
import {AlertService} from "./services/alert.service";
import {AuthGuard} from "./guards/auth.guard";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavComponent,
    SearchPipe,
    SignupComponent,
    ProfileComponent,
    AdminComponent,
    HomepageComponent,
    CartComponent,
    BuyComponent,
    SellComponent,
    AlertComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatTabsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [AuthService, AlertService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
