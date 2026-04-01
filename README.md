# Smart Hostel Management System (BITS Pilani Goa Campus)

## 📌 Project Overview
This is a streamlined Java-based system for managing hostel operations. It utilizes a flat package structure (`package hostel`) to ensure ease of compilation and execution while adhering to strict OOP principles.

---

## 🛠️ Requirement Mapping

| Requirement | Implementation Location |
| :--- | :--- |
| **Package** | All files belong to `package hostel;`. |
| **Abstract Class** | `User.java` (Base class for all residents and staff). |
| **Interface** | `SecurityProtocol.java` (Standardizes logging and alerts). |
| **Inheritance** | Hierarchical: `Student` and `Admin` both extend `User`. |
| **Nested Classes** | `Student.GuardianDetails` (Non-static) & `Room.RoomType` (Static). |
| **Overloading** | `FinanceManager` (Method overloading) and `Room` (Constructor overloading). |
| **Varargs** | `Admin.notifyResidents(String msg, String... ids)`. |
| **Wrappers** | `ArrayList<Double>` and `Integer` used in Finance and Room tracking. |
| **Exception Handling** | 3 Custom cases: `RoomFull`, `Unauthorized`, and `PaymentFailed`. |
| **File I/O** | `MessManager` (Reads menu) and `Main` (Scanner for user input). |

---

## 🚀 Key Functional Modules
1. **Resident Management:** Tracks BITS Goa student details and guardian info via nested classes.
2. **Room Allocation:** Logic to manage capacity and handle room changes.
3. **Mess & Food:** File-based menu management and feedback collection.
4. **Security & Visitors:** Interface-driven logging system for campus safety.
5. **Fee Management:** Wrapper-based financial calculations and payment overloading.

---

## ⚙️ Compilation & Execution
To compile and run the system from the `src` directory:

1. **Compile:** `javac hostel/*.java`

2. **Run:** `java hostel.Main`

---
