import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { DBserviceService } from '../dbservice.service';
import { element } from 'protractor';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  employees:Employee;
  
  
  constructor(public dbservice:DBserviceService) { }

  ngOnInit() {
    this.getEmpId();
  }
  getEmpId():void{
    this.dbservice.getAllEmployee().subscribe(employee  =>this.employees=employee);

  }
  delete(id:number){
    this.dbservice.deleteEmployee(id).subscribe(res=>this.employees);
      
      
  }
  
}
