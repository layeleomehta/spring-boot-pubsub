package com.pubsub.publisher.pubsub

import com.google.cloud.spring.pubsub.core.PubSubTemplate
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.messaging.MessageHandler

const val DEMO_CHANNEL = "demoChannel"

@Configuration
class PubSubConfiguration(
    @Value("\${pubsub.topics.demoTopic}") private val demoTopic: String
) {
    @Bean
    @ServiceActivator(inputChannel = DEMO_CHANNEL)
    fun demoMessageSender(pubSubTemplate: PubSubTemplate): MessageHandler {
        return PubSubMessageHandler(pubSubTemplate, demoTopic)
    }
}
