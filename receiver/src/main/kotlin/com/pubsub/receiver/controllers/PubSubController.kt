package com.pubsub.receiver.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/getMessage")
class PubSubController {
    private val message: String = ""

    @GetMapping
    fun getMessage(): String {
        if(message == "") {
            return "No messages have been passed yet"
        }

        return "This message went through a GCP Pub/Sub channel: $message"
    }
}
