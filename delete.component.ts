import { Component, OnInit } from '@angular/core';
import { DBserviceService } from '../dbservice.service';
import { Employee } from '../employee';



@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  
  constructor(public dbservice:DBserviceService) { }

  ngOnInit() {

  }
  
  


}
