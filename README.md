📚 Library Management System – Mini Project Unit 1 Integration – OOP, Collections, Exceptions & File Handling

This mini-project is a command-line Java application that simulates a basic Library Management System (LMS). It integrates all core concepts from Unit 1, including Object-Oriented Programming, Java Collections, Exception Handling, and File I/O.

🎯 Project Objectives

This project demonstrates:

OOP Concepts: Classes, objects, encapsulation, methods

Collections: HashMap & ArrayList for managing library data

Custom Exceptions: Error handling for invalid operations

File Handling: Logging library activities to a text file

Menu-Driven Program: User interaction via terminal

📌 Functional Components ✔ 1. Book Class

Represents a book in the library.

Fields:

id – Unique book ID

title – Title of the book

author – Author name

isIssued – Availability status

Methods:

Constructor

Getters & setters

toString() to print book info

✔ 2. Member Class

Stores information about a library member.

Fields:

memberId – Unique member ID

name – Member name

borrowedBookIds – List of issued book IDs

Methods:

Constructor

Getters & setters

borrowBook(String bookId)

returnBook(String bookId)

✔ 3. Library Class

Main logic of the system.

Fields:

inventory – HashMap<String, Book>

members – HashMap<String, Member>

Methods:

addBook(Book book)

addMember(Member member)

issueBook(String bookId, String memberId)

returnBook(String bookId, String memberId, int daysLate)

logOperation(String message) → Writes to a log file

showInventory()

✔ 4. Custom Exceptions

BookNotAvailableException Thrown when a book is not found or already issued.

InvalidReturnException Thrown when a return is invalid (wrong member, wrong book, etc.).

✔ 5. Main Class

Menu-driven CLI using Scanner.

Options:

Add a book

Issue a book

Return a book (late fee = ₹2 per day)

Show inventory

Exit

📁 Project Structure src/ ├── Book.java ├── Member.java ├── Library.java ├── BookNotAvailableException.java ├── InvalidReturnException.java └── Main.java

▶ How to Run

Compile:

javac *.java

Run:

java Main

📝 File Logging

All operations are written to a log file, for example:

log.txt

Sample log entries:

[ADD] Book added: B101 - Java Basics [ISSUE] Book B101 issued to M001 [RETURN] Book B101 returned by M001 | Late fee: ₹4

🎯 Learning Outcomes

By completing this mini-project, you will learn:

How to create modular OOP-based Java applications

Using HashMap and ArrayList effectively

Designing and throwing custom exceptions

Writing and appending logs using FileWriter/BufferedWriter

Creating user menus and handling invalid input

👨‍💻 Author

Ahamed Irfan Mini Project – Library Management System
