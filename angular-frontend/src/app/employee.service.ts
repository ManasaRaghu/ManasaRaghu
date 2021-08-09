import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})

export class EmployeeService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  private baseURL = "http://localhost:8080/api/v1/employees";

  constructor( private httpClient : HttpClient ) { }

    getEmployeeList():Observable<Employee[]>{
      return this.httpClient.get<Employee[]>(`${this.baseURL}`);
    }

    createEmployee(employee: Employee): Observable<object>{
      console.log(employee);
      return this.httpClient.post<Employee>(`${this.baseURL}` , employee, this.httpOptions);
    }

    updateEmployee(id: number,employee:Employee):Observable<Object>{
      console.log(employee);
      return this.httpClient.put(`${this.baseURL}/${id}`,employee);
    }

    getEmployeeById(id: number):Observable<Employee>{
      return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
    }   

    deleteEmployee(id: number):Observable<any>{
      return this.httpClient.delete(`${this.baseURL}/${id}`);
    }
  }
