# messages-ms

### MessageTester
10 seconds after MS starts to run up,
MessageTester starts running and injects 20 messages for testing.

### SMSMessageHandler
processing SMS message invokes sleep thread between 1-10 seconds random.

### Thread
Except for the main thread, we have a single thread that listener the queue and put message request in processing in a thread from the pool thread.

* Pool thread size value configure in application.properties file.

##

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
