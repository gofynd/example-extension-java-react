
# Sample Java - React extension

[![Coverage Status][coveralls-badge]]([coveralls-url])

### Built With
![NodeJS](https://img.shields.io/badge/node.js-6DA55F?style=for-the-badge&logo=node.js&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

[coveralls-badge]: https://coveralls.io/repos/github/gofynd/example-extension-java-react/badge.svg?branch=main&&kill_cache=1
[coveralls-url]: https://coveralls.io/github/gofynd/example-extension-java-react?branch=main



## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple steps :

### Prerequisites
List of mandatory Services to be downloaded on your System

    1. Java 14 or higher
    2. Maven 
    2. Redis

### Steps to Execute

* Clone the project : [Git link](https://github.com/gofynd/example-extension-java-react)
* Open the Spring boot project on any IDE
* Build Front-end dist files
    ```shell
    cd app
    npm i 
    npm run build
    ```
* Run the application
  ```
  mvn clean install
  mvn spring-boot:run  
  ```
* Server starts on *8080*

### Docker Instructions

To run the application using Docker, follow these steps:
* Build the Docker image:
    ```shell
    docker build -t my-java-react-app .
    ```
* Run the Docker container
  ```
  docker run -p 8080:8080 my-java-react-app 
  ```
* Server starts on *8080*

### Tests
Use the Below Controller to Test the Application :

* HealthController : Uses the Actuator Health points to check if all the resources are stable and active

        http://localhost:8080/_healthz

