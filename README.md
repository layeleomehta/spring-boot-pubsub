# Getting more familiar with GCP's Pub/Sub service in Spring Boot

**What I learned:**

Google Pub/Sub is an asynchronous messaging service based on the publisher-subscriber model. It consists of topics, or channels. Each topic can be published to, and it can have multiple subscribers. Spring Boot services can listen to messages that go through a certain topic, and they can also publish messages to topics.

To listen to a message from a certain topic, a Spring Boot application must listen to the topic's subscriber. The PubSubTemplate authorizes the Spring Boot service's GCP credentials, and if they're valid, sends the subscription off to an InboundChannelAdapter. The adapter receives the messages from the GCP subscription, and sends the messages off to an internal Spring channel. A ServiceActivator then monitors the internal Spring channel, and is triggered every time a new message is passed through the channel. Functions can be annotated with a ServiceActivator, and the message can then be transformed safely. 

To send messages to a certain topic, a Spring Boot application must have a way to get message input from a user, and then create a MessageGateway. The MessageGateway will send the message to an internal Spring channel. A ServiceActivator will listen to the internal Spring channel, and be triggered every time a new message enters the channel. Once triggered, the ServiceActivator will send off this message to the OutboundChannelAdapter, which will deliver the message to the GCP topic. Once this topic receives the message, it will publish it to all of its subscribers on GCP. 
