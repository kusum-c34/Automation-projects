# QA Automation Project

## Project Overview

This project is a Selenium-based automation testing framework developed using Java, TestNG, Maven, and Page Object Model (POM).

The project automates the complete shopping flow of the SauceDemo website.

## Application Under Test

https://www.saucedemo.com/

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- PageFactory
- IntelliJ IDEA
- Git & GitHub

## Test Scenario

The automation test covers the following flow:

1. Login to SauceDemo
2. Verify Products page
3. Add Backpack to cart
4. Verify cart item count
5. Open Cart
6. Verify Cart page
7. Proceed to Checkout
8. Enter customer details
9. Continue to Checkout Overview
10. Verify Checkout Overview page
11. Finish the order
12. Verify Order Completion

## Project Structure

```text
QA-Automation-Project
│
├── src
│   ├── main
│   │   └── java
│   │       ├── base
│   │       │   └── BaseTest.java
│   │       │
│   │       ├── pages
│   │       │   ├── LoginPage.java
│   │       │   ├── ProductsPage.java
│   │       │   ├── CartPage.java
│   │       │   ├── CheckoutPage.java
│   │       │   └── CheckoutOverviewPage.java
│   │       │
│   │       └── utils
│   │           └── ExtentReportManager.java
│   │
│   └──test
└── java
    └── tests
        ├── CartTest.java
        ├── CheckoutTest.java
        └── LoginTest.java
├── pom.xml
└── README.md
## Author

Kusum