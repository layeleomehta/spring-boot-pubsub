package com.pubsub.receiver.controllers

import com.pubsub.receiver.pubsub.DEMO_SUBSCRIPTION_CHANNEL
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/getMessage")
class PubSubController {
    private var message: String = ""

    @GetMapping
    fun getMessage(): String {
        if(message == "") {
            return "No messages have been passed yet"
        }

        return "This message went through a GCP Pub/Sub channel: $message"
    }

    @ServiceActivator(inputChannel = DEMO_SUBSCRIPTION_CHANNEL)
    fun receiveMessage(payload: String): Unit {
        this.message = payload
    }
}
