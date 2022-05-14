import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CatalogueService} from "../service/catalogue.service";

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  public clients:any;
  public accounts:any;

  constructor(private catService:CatalogueService) { }

  ngOnInit(): void {

  }

  onGetClients() {
    this.catService.getClients()
      .subscribe(data=>{
        this.clients=data;
      },error => {
        console.log(error)
      })
  }

  onChercher(value: any) {
    console.log(value);
  }

  onComptesClients(id:bigint) {
    this.catService.getCustomerAccounts(id)
      .subscribe(data=>{
        this.accounts=data;
      }, error => {
        console.log(error)
      })
  }
}
