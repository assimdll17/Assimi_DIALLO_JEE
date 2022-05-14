import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CatalogueService {

  constructor(private httpClient:HttpClient) { }

  public getClients(){
    return this.httpClient.get("http://localhost:8085/customers");
  }

  public getCustomerAccounts(id:bigint){
    return this.httpClient.get("http://localhost:8085/account/customer/"+id)
  }
}
