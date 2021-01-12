package com.dynamodbkotlin.controller

import com.dynamodbkotlin.entity.Employee
import com.dynamodbkotlin.repository.EmployeeRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
class EmployeeController (private val employeeRepository: EmployeeRepository) {

    @PostMapping("/employee")
    fun saveEmployee(@RequestBody employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    @GetMapping("/employee/{employeeId}")
    fun getEmployee(@PathVariable employeeId: String) =
        employeeRepository.getEmployeeById(employeeId) ?: throw
                ResponseStatusException(HttpStatus.NOT_FOUND, "Employee does not exist")

}
