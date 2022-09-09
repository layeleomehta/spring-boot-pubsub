package com.pubsub.publisher.pubsub

import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.MessagingGateway
import com.pubsub.publisher.pubsub.DEMO_CHANNEL

@Configuration
@MessagingGateway(defaultRequestChannel = DEMO_CHANNEL)
interface DemoPublisher {
    fun sendToPubSub(message: String)
}
