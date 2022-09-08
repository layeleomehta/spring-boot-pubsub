package com.pubsub.receiver.pubsub

import com.google.cloud.spring.pubsub.core.PubSubOperations
import com.google.cloud.spring.pubsub.integration.AckMode
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.MessageChannel

const val DEMO_SUBSCRIPTION_CHANNEL = "demoSubscriptionChannel"

@Configuration
class PubSubConfiguration(
    @Value("\${receiver.pubsub.demoSubscription}") private val demoSubscription: String
) {
    // this is a bean which is referred to by the name of the demo subscription channel
    @Bean(DEMO_SUBSCRIPTION_CHANNEL)
    fun demoInput(): MessageChannel {
        // this returns an internal Spring channel
        return DirectChannel()
    }

    @Bean
    fun demoChannelAdapter(
        @Qualifier(DEMO_SUBSCRIPTION_CHANNEL) inputChannel: MessageChannel,
        pubSubOperations: PubSubOperations
    ): PubSubInboundChannelAdapter {
        val adapter = PubSubInboundChannelAdapter(pubSubOperations, demoSubscription)
        adapter.outputChannel = inputChannel
        adapter.ackMode = AckMode.AUTO
        return adapter
    }

}
