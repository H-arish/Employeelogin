import { Component, OnInit, Input } from '@angular/core';
import {  Employee } from '../employee';
import { DBserviceService } from '../dbservice.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  @Input() employee:Employee;
  constructor(public dbservice:DBserviceService,private route:ActivatedRoute) { }

ngOnInit() {
  this.getEmployee();
}

getEmployee():void{
  const eid = +this.route.snapshot.paramMap.get('empId');
  console.log('eid');
  this.dbservice.getEmployeeID(eid).subscribe(res  =>this.employee=res);
}

save() : void{
  this.dbservice.updateEmployee(this.employee).subscribe();
}


}

