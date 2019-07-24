# Getting Started

###MessageTester
10 seconds after MS starts to run up,
MessageTester starts running and injects 20 messages for testing

###SMSMessageHandler
processing sms message invoke sleep thread between 1-10 seconds random

###Thread
Except from the main thread, we have single thread that listener the queue and put message request in processing in thread from the pool thread.
######pool thread size value configure in application.properties file

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

