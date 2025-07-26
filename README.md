 CPUT Computer Booking System – Description & Development Plan
 What is the Computer Booking System?
The CPUT Computer Booking System is a software application designed for students, administrators, and faculty at the Cape Peninsula University of Technology (CPUT) to book computer lab sessions on campus.

This system:

Allows students to view and book available computer lab slots.

Enables administrators to create, verify, and manage bookings.

Prevents double bookings and ensures fair access to lab resources.

Tracks which students have used which labs, and when.

 Why are we building it?
To solve problems like:

Overcrowding in labs.

Manual booking processes.

Lack of transparency on availability.

Unverified users using labs without permission.

🔧 How Will We Build It?
We will follow Object-Oriented Programming (OOP) principles using Java, and break the system into several layers:

📁 1. Domain Layer (Entities)
These represent the core data models:

User (superclass)

Student (extends User)

Admin

Booking

Verification

Session

Notification

Each class includes attributes, constructors (with Builder pattern), getters, and logic (e.g., canPerform(), verifyUser()).

🏭 2. Factory Layer
Factories are used to create domain objects without writing long constructors. Example:

AdminFactory.createAdmin(...)

BookingFactory.createBooking(...)

📚 3. Repository Layer
Repositories manage data storage using in-memory HashMaps (or databases in future):

CRUD operations: create(), read(), update(), delete()

Example: AdminRepository, BookingRepository

🔧 4. Service Layer (optional for advanced logic)
Used for business rules like:

Validating booking conflicts

Checking if users meet requirements

🛠️ 5. Utility Layer
Helpers that support the system, e.g.:

Helper.java → for ID generation, validation, and formatting

DateTimeUtil.java → (optional) for working with timeslots

🖥️ 6. Main Application Layer
Where everything comes together:

Run and test logic via Main.java

Simulate creating users, bookings, and viewing outcomes.

🧪 7. Testing (JUnit)
Create unit tests for factories, services, and repositories.

Example: AdminFactoryTest, BookingServiceTest

 Optional Features to Add Later:
GUI (JavaFX or Swing) for user interaction.

Integration with a database (MySQL or PostgreSQL).

Email notifications.

Login authentication.

📌 Summary:
Layer	Responsibility
Domain	Models (Admin, Student, Booking, etc.)
Factory	Object creation
Repository	Store and retrieve objects
Utility	Helper methods (e.g. ID, validation)
Main	Runs the program
(Optional) UI	JavaFX/Swing for user interface
