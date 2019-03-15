import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { CustomMaterialModule } from './module/material.module';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MakerComponent } from './components/maker/maker.component';
import { CheckerComponent } from './components/checker/checker.component';
import { LoginComponent } from './components/login/login.component';
import {ApiService} from './services/makerchecker.service';
import {LoginApiService} from './services/login.service';

import { HttpClientModule } from '@angular/common/http';
import {  HttpClient } from '@angular/common/http';
import { MakerCreateComponent } from './components/maker/maker-create/maker-create.component';
import { MakerViewComponent } from './components/maker/maker-view/maker-view.component';
import { CheckerSearchComponent } from './components/checker/checker-search/checker-search.component';
import { CheckerActionsComponent } from './components/checker/checker-actions/checker-actions.component';
@NgModule({
  declarations: [
    AppComponent,
    MakerComponent,
    CheckerComponent,
    LoginComponent,
    MakerCreateComponent,
    MakerViewComponent,
    CheckerSearchComponent,
    CheckerActionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [ApiService, HttpClient, LoginApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
