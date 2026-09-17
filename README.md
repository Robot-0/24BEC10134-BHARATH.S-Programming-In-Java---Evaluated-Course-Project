# Smart Campus Library Management System (SCLMS)

## Overview
The Smart Campus Library Management System (SCLMS) is a modular, console-based Java application built using a layered MVC architecture. The system manages library inventory, tracks student book issuances and returns, enforces borrowing limits, and calculates daily overdue fines.

---

## Features
- **Inventory Management:** View, add, and search books by unique IDs.
- **Borrowing Engine:** Issue and return books with automated availability tracking and student limit enforcement (Max 3 books per student).
- **Fine Calculation:** Automatic calculation of overdue daily fines ($2.00/day).
- **Custom Exception Handling:** Graceful error reporting for missing books (`BookNotFoundException`) or exceeded borrowing quotas (`UserLimitExceededException`).
- **Data Persistence:** File-based data access layer (`FileBookDAO`) for persistent storage.

---

## Technologies & Tools Used
- **Language:** Java (JDK 11+)
- **IDE / Editor:** Visual Studio Code
- **Version Control:** Git & GitHub
- **Build System:** Manual CLI compilation via `javac`

---

## Installation & Setup Instructions

### Prerequisites
Ensure you have the Java Development Kit (JDK 11 or higher) installed on your system.

### Compilation
Open your terminal in the project root directory and run:

```bash
mkdir bin
javac -cp src -d bin src/com/library/model/*.java src/com/library/exception/*.java src/com/library/dao/*.java src/com/library/util/*.java src/com/library/service/*.java src/com/library/*.java
