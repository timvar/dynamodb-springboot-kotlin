package com.dynamodbkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DynamodbKotlinApplication

fun main(args: Array<String>) {
    runApplication<DynamodbKotlinApplication>(*args)
}
