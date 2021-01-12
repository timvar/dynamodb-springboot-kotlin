package com.dynamodbkotlin.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoDbConfig {
    @Value("\${amazon.aws.accesskey}")
    private val awsAccessKey: String? = null

    @Value("\${amazon.aws.secretkey}")
    private val awsSecretKey: String? = null

    @Value("\${amazon.region}")
    private val awsRegion: String? = null

    @Value("\${amazon.dynamodb.endpoint}")
    private val awsDynamoDBEndPoint: String? = null
    @Bean
    fun dynamoDBMapper(): DynamoDBMapper {
        return DynamoDBMapper(amazonDynamoDBConfig())
    }

    private fun amazonDynamoDBConfig(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder
            .standard()
            .withEndpointConfiguration(
                EndpointConfiguration(
                    awsDynamoDBEndPoint, awsRegion
                )
            )
            .withCredentials(
                AWSStaticCredentialsProvider(
                    BasicAWSCredentials(
                        awsAccessKey,
                        awsSecretKey
                    )
                )
            )
            .build()
    }
}