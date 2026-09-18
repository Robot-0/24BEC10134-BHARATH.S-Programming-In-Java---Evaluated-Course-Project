# Project Statement & Scope: Smart Campus Library Management System (SCLMS)

## Problem Statement
Traditional library operations often face challenges with manual tracking, leading to misplaced books, inaccurate availability status, unverified borrowing limits and inconsistent overdue fine calculations. Educational institutions require an automated, structured software system to streamline inventory management, enforce student borrowing rules, and handle exception scenarios effectively without administrative overhead.

---

## Scope of the Project
The scope of SCLMS encompasses a core object-oriented library management engine built with Java using a layered MVC architecture.

**In-Scope:**
- Console-based user interaction for issuing, returning, and viewing catalog items.
- Business rule enforcement, including student borrowing quotas (maximum 3 books) and availability tracking
- Exception handling for missing records or quota breaches using custom exception classes
- Automated daily overdue final calculation engine
- Persistent file-based storage layer via Data Access Objects (DAO).

**Out-of-Scope:**
-Graphical User Interface (GUI) or Web-based frontend
-Relational Database Management (RDBMS)integration (SQL)
-Online payment gateway integration for fine settlements

---
## Target Users
-**Students:** Library patrons who query book availability, borrow titles, return items, and check calculated overdue fines.
-**Librarians/Admins:** System administrators responsible for updating inventory status, monitoring borrowing quotas, and managing catalog records.

---
## High-Level Features
1. **Catalog Management:** Add, update and list library books with real-time availability tracking.
2. **Issue and Return Engine:** Check out and return books safely while updating persistent storage.
3. **Borrowing Limit Enforcement:** Restrict student checkout transactions if their current borrowing limit is reached
4. **Fine Calculations:** Automatically evaluate daily penalty rates ($2.00/day) based on overdue duration.
5. **Robust Error Handling:** Throw and handle custom exceptions (`BookNotFoundException`, `UserLimitExceededExceptions`) to ensure graceful application recovery.
