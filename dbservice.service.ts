import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { ReturnStatement } from '@angular/compiler';
import {Employee} from './employee';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DBserviceService {
  public Url = 'http://localhost:8001/middleware/api/emp/';
 

  constructor(public http: HttpClient) { }

  addEmployee (emp: Employee): Observable<Employee> {
    console.log("service"+emp.empId);
   return this.http.post<Employee>(this.Url, emp, httpOptions).pipe(
   
     catchError(this.handleError<Employee>('addEmployee'))
   );
 }

 getAllEmployee():Observable<Employee>{
   return this.http.get<Employee>(this.Url).pipe(
     catchError(this.handleError<Employee>('getAllEmployee'))
   );
 }

 updateEmployee (emp:Employee): Observable<Employee> {
    console.log("service"+emp.empId);
  return this.http.put<Employee>(this.Url, emp, httpOptions).pipe(
   catchError(this.handleError<Employee>('updateEmployee'))
  );
}

deleteEmployee(empId:number)
  {
    console.log("service delete for "+empId)
    return this.http.delete(this.Url+"/"+empId);
}

getEmployeeID(eid : number) : Observable<Employee>{
  console.log(eid)
  const url = `${this.Url}/${eid}`;
  return this.http.get<Employee>(url);
}

 
 private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {
    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    // Let the app keep running by returning an empty result.
    return of(result as T);
  };
}


}

