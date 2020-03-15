import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import {DBserviceService} from '../dbservice.service';

@Component({
  selector: 'app-insert',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent implements OnInit {
 employees:Employee[];
  constructor(public dbservice:DBserviceService) { }

  ngOnInit() {
  }
  add(empId:number,ename:string,email:string,phone:string): void {
    console.log(empId);
    empId=empId;
    ename=ename;
    email=email;
    phone=phone;

    this.dbservice.addEmployee({empId,ename,email,phone} as Employee)
     .subscribe(employee => {
      this.employees.push(employee);
         console.log('inside add');
        });
       
   }

}
