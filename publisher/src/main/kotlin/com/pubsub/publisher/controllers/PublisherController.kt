package com.pubsub.publisher.controllers

import com.pubsub.publisher.models.DemoMsg
import com.pubsub.publisher.pubsub.DemoPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sendMessage")
class PublisherController(
    private val gateway: DemoPublisher
) {
    @PostMapping
    fun publishMessage(@RequestBody msg: DemoMsg): String {
        gateway.sendToPubSub(msg.message)
        return "Message sent to GCP successfully!"
    }
}
