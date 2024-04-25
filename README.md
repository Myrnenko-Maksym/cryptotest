# Testing API for Cryptocurrency

This application contains three simple tests to verify wallet functionality for cryptocurrency transactions.

## Technologies

* [Java 11](https://duckduckgo.com/?t=ffab&q=Java+11) The programming language used.
* [TestNG](https://mvnrepository.com/artifact/org.testng/testng/7.4.0) A testing framework designed to cover all categories of tests: unit, functional, end-to-end, integration, etc.
* [Retrofit](https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit/2.9.0) a type-safe REST client for
  Android, Java and Kotlin developed by Square.

## Setup development machine

* Install Java JDK 11: Ensure Java JDK 11 is installed on your development machine
* Install Maven: Maven 4.0.0 or newer is required.

## Project dependencies

This project is managed by Maven, which handles all dependencies automatically.

**If it happens that you have some errors while compiling the project, and you
are sure your code is correct, try reloading maven dependencies and see if that
solves the problem. If reloading does not help, delete everything from .m2 folder
and try again.**

## Tests execution

### Execute tests from IntelliJ IDE

#### - Create a TestNG Run All Tests Configuration
* Set your own token and API key in the ConfigValues.properties file.
* Declare all objects from the properties file in the ConfigValues interface.

## Setup folder
* This folder contains all methods and interfaces required for tests. The BlockIoService interface is used to create request templates via Retrofit.
* The RetrofitClient class consists of all methods necessary to operate with data in tests.

## Payments folder for test
* This folder contains API tests for the application.
