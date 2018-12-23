# Qudini web developer code test

To test how quickly you can pick up a new project and follow requirements we ask candidates to do the following project. You have a choice of web frameworks you can use: 

- Play Framework 2 : (Play 2.x https://www.playframework.com/download)
- Spring WebFlux : https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html

that meets the following requirements: 

- Fork this project 
- Start project in the chosen framework
- Provide an API which accepts a list of json 'customer' objects in the body of a POST request (see json example attached). 
- The API should take this list of objects and sort them by due time then return this back as a sorted json array.
- Should use the Joda time (http://www.joda.org/joda-time/) library to handle times with timezones.  
- The API should be non-blocking and be as efficient as possible in its sorting. 
- We'll test this by load testing the project with a few hundred users to see how it performs (if you have time try using Jmeter to test your implementation). 

Bonus points: 

- Some tests to ensure your code is working as expected
- An API is great, but how about adding some UI for easy upload of the file. 


From Viktorija:

to start the spring boot application:
    cd java-play-codetest/customers
    mvn clean install
    mvn spring-boot:run

to run the react app open a new tab:
    cd java-play-codetest/customers-board-react/
    npm install
    npm start

to run the cucumber tests open a new tab: 
    right click on the file "cucumber-tests/src/test/resources/features/customers.feature"
