import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientsComponent } from './clients/clients.component';
import { NewClientComponent } from './new-client/new-client.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { CompteComponent } from './compte/compte.component';
import { ComptesClientComponent } from './comptes-client/comptes-client.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientsComponent,
    NewClientComponent,
    CompteComponent,
    ComptesClientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule, FormsModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
