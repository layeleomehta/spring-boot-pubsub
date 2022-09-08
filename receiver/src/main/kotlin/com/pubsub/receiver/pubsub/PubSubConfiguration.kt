package com.pubsub.receiver.pubsub

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class PubSubConfiguration(
    @Value("\${receiver.pubsub.demoSubscription}") private val demoSubscription: String
) {

}
