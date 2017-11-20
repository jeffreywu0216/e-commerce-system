import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './/app-routing.module';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCheckboxModule } from '@angular/material';
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
    SellComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
