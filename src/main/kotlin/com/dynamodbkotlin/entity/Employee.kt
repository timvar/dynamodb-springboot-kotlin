package com.dynamodbkotlin.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor



@DynamoDBTable(tableName = "employee")
data class Employee @JvmOverloads constructor (
    @DynamoDBHashKey @DynamoDBAutoGeneratedKey var employeeId: String = "",

    @DynamoDBAttribute var firstName: String = ""

/*
    @DynamoDBAttribute
    private String lastName;



    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private Department department;

    */
)