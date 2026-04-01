# QA Automation Framework 🚀

## 📌 Overview

This project is a scalable Selenium automation framework built using Java, TestNG, and Maven. It supports parallel cross-browser execution using Dockerized Selenium Grid and integrates with GitHub Actions for CI/CD.

---

## 🧰 Tech Stack

* Java 21
* Selenium 4
* TestNG
* Maven
* Docker (Selenium Grid)
* GitHub Actions (CI/CD)
* Allure Reporting

---

## 🏗️ Framework Architecture

```
Tests (TestNG)
   ↓
Page Objects (POM)
   ↓
BrowserFactory
   ↓
RemoteWebDriver
   ↓
Dockerized Selenium Grid
   ↓
Browsers (Chrome / Firefox)
```

---

## ⚙️ Features

* ✅ Page Object Model (POM)
* ✅ Parallel Execution (ThreadLocal)
* ✅ Cross-Browser Testing (Chrome + Firefox)
* ✅ Dockerized Selenium Grid
* ✅ CI/CD using GitHub Actions
* ✅ Allure Reporting (screenshots, steps, categories)
* ✅ Test Grouping (Smoke / Regression)
* ✅ Scheduled Test Runs

---

## 🚀 Running Tests Locally

### Run on local browser:

```
mvn clean test
```

### Run on Selenium Grid:

```
mvn clean test -Dgrid.url=http://localhost:4444/wd/hub
```

---

## 🐳 Running Selenium Grid (Docker)

```
docker run -d -p 4444:4444 selenium/standalone-chrome
```

---

## 🔁 Cross-Browser Execution

Handled via GitHub Actions matrix:

* Chrome
* Firefox

---

## 📊 Allure Reports

### Generate report locally:

```
allure serve target/allure-results
```

### CI:

* Reports generated automatically
* Uploaded as artifacts

---

## ⚡ CI/CD Pipeline

Implemented using GitHub Actions:

* Triggered on push and pull request
* Spins up Dockerized Selenium Grid
* Executes tests in parallel (matrix)
* Generates and uploads Allure reports

---

## 📅 Scheduled Runs

Automated test execution using cron jobs for regression runs.

---

## 🧠 Design Highlights

* Centralized Driver Management using BrowserFactory
* Supports local and remote execution seamlessly
* Clean separation of concerns using POM
* Scalable CI pipeline with parallel execution

---

## 📌 Future Improvements

* Retry mechanism for flaky tests
* Publish Allure reports to GitHub Pages
* Slack/Email notifications
* Environment-based execution

---

## 👤 Author

Chayan Ghosh
