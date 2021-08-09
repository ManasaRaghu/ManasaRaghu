import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service'

@Component({
  selector: 'app-insert-employee',
  templateUrl: './insert-employee.component.html',
  styleUrls: ['./insert-employee.component.css']
})
export class InsertEmployeeComponent implements OnInit {

  employee: Employee = new Employee();


  constructor(private employeeService: EmployeeService,
    private router: Router ) { }

  ngOnInit(): void {
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data => {
      console.log(data);
      this.goToEmployeeList();
    })
    
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

    onPress(){
      console.log(this.employee);
      this.saveEmployee();
    }
  

}
