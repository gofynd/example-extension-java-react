
# Build a Fynd Extension using Java + React.js
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)

[coveralls-badge]: https://coveralls.io/repos/github/gofynd/example-extension-java-react/badge.svg?branch=main&&kill_cache=1
[coveralls-url]: https://coveralls.io/github/gofynd/example-extension-java-react?branch=main
[![Coverage Status][coveralls-badge]]([coveralls-url])

This project outlines the development process for a Fynd extension that displays product listings for a company and its associated applications. By following this guide, you'll be able to set up the development environment, build the extension locally, and understand the testing procedures.

## Quick start
### Prerequisites
* You have installed globally [Node 16.X.X](https://docs.npmjs.com/) or above version.
* You have fdk-cli installed [install](https://github.com/gofynd/fdk-cli)
* You have created a [partner account](https://partners.fynd.com).
* You have created a [development account](https://partners.fynd.com/help/docs/partners/testing-extension/development-acc#create-development-account) and [populated test data](https://partners.fynd.com/help/docs/partners/testing-extension/development-acc#populate-test-data) in it.
* You have downloaded and installed following on your System
    1. [Java 14](https://www.java.com/en/) or higher
    2. [Maven](https://maven.apache.org/download.cgi)
    
  
## Install Template Locally
To initialize your extension template locally, run the following command:
```shell
fdk extension init --template java-react
```
Enter your preferred extension name and type, and you are all set.

## Local Development
To start local development, execute the following command:
```shell
fdk extension preview
```
This command will provide a partner’s panel URL where you can interact with your extension. For more information, please read this [guide](https://github.com/gofynd/fdk-cli?tab=readme-ov-file#extension-commands).

## Docker Instructions

To run the application using Docker in Production environment, follow these steps:
* Build the Docker image:
    ```shell
    docker build -t my-java-react-app .
    ```
* Run the Docker container
  ```
  docker run -p 8080:8080 my-java-react-app 
  ```
To Run the extension with Docker locally, ensure you first prepare your environment:

Fill in all the required values in the application-prod.yml file. 
After setting up your .yml file, you can proceed with the Docker commands listed above to build and run your extension locally.


## Database Configuration

By default, this template uses an `SQLite` database to store session data. SQLite is sufficient for development purpose only, it may not be suitable for all production scenarios. The best database for your application depends on your data requirements and query patterns.

If your app requires a more robust database solution, you can easily extend the base storage class provided by the `fdk-extension-java` library to use a database of your choice for session data. Here are some databases that we support by default:

- SQLite
- Memory Storage
- Redis

Feel free to configure and run your preferred database on your server to meet your specific needs.

## Tech Stack
1. [fdk-client-java](https://github.com/gofynd/fdk-client-java): This library contains all the methods to call Fynd platform APIs.
2. [fdk-extension-java](https://github.com/gofynd/fdk-extension-java): This library streamlines the setup of authentication for accessing Fynd Platform APIs. It also simplifies the process of subscribing to webhooks for receiving real-time notifications.


[coveralls-badge]: https://coveralls.io/repos/github/gofynd/example-extension-javascript-react/badge.svg?branch=main&&kill_cache=1
[coveralls-url]: https://coveralls.io/github/gofynd/example-extension-javascript-react?branch=main
