package com.dynamodbkotlin.repository

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.dynamodbkotlin.entity.Employee
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepository(private val dynamoDBMapper: DynamoDBMapper) {

    fun save(employee: Employee): Employee {
        dynamoDBMapper.save<Any>(employee)
        return employee
    }

    fun getEmployeeById(employeeId: String?): Employee? {
        return dynamoDBMapper.load(Employee::class.java, employeeId)
    }
/*
    public String delete(String employeeId) {
        Employee emp = dynamoDBMapper.load(Employee.class, employeeId);
        dynamoDBMapper.delete(emp);
        return "Employee deleted";
    }

    public String update(String employeeId, Employee employee) {
        dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression()
        .withExpectedEntry("employeeId",
                new ExpectedAttributeValue(new AttributeValue().withS(employeeId)
                )));
        return employeeId;
    }

 */
}