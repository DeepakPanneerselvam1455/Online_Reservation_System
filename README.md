# Online Reservation System - README

## Project Overview

The **Online Reservation System** is a Java-based application that enables users to register, log in, and make reservations for available services. The system supports functionalities such as viewing reservations, seat availability checks, and processing payments. The application is built with a simple text-based interface, where users can interact with the system via a command-line interface. 

### Features
- **User Registration and Login**: Users can register their accounts and securely log in with their credentials.
- **Seat Availability**: Users can check if a specific seat is available for their desired date.
- **Reservation Management**: Users can make reservations, including selecting a date, time, and seat.
- **Payment Processing**: Users can pay for their reservation, with a simulated payment process.
- **View Reservations**: Registered users can view all their past and upcoming reservations.
- **Admin and User Roles**: The system differentiates between admin-level and user-level functionality.

### Technologies Used
- **Programming Language**: Java
- **Data Structures**: ArrayList, HashMap
- **User Interface**: Command-line interface (CLI)
- **Authentication**: Email-based login system
- **Payment Simulation**: Simple method for simulating payment processing
- **Version Control**: Git

## Installation

### Prerequisites
- Java 8 or later installed on your system.
- An IDE (Integrated Development Environment) like IntelliJ IDEA, Eclipse, or VS Code is recommended for ease of use.

### Steps to Set Up
1. **Clone the Repository**:
   ```bash
   git clone: github.com/DeepakPanneerselvam1455/Online_Reservation_System.git
   ```

2. **Install Java**:
   - Download and install [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) if it's not already installed.

3. **Set up the Project**:
   - Open the project folder in your IDE or in your terminal.
   - If you are using an IDE, you may want to import the project as a Maven or Gradle project, depending on your IDE's capabilities.

4. **Run the Application**:
   - Compile and run the `OnlineReservationSystem.java` class, which contains the `main()` method to start the application.
   
   In terminal, navigate to the project directory and run:
   ```bash
   javac OnlineReservationSystem.java
   java OnlineReservationSystem
   ```

## Usage

### User Interface (CLI)
Once the system is up and running, you can interact with it via a command-line interface with the following options:

1. **Register**: Create a new user account by providing name, contact, email, and password.
2. **Login**: Log in using your registered email and password.
3. **Make a New Reservation**: After logging in, you can make a reservation by selecting a seat, date, time, and paying for it.
4. **View My Reservations**: View all reservations made by the currently logged-in user.
5. **Exit**: Exit the system.

### Example Interaction:
```
Welcome to the Online Reservation System

1. Register
2. Login
3. New Reservation
4. View My Reservations
5. Exit
Enter your choice: 1
Enter your name: John Doe
Enter your contact: 123456789
Enter your email: john@example.com
Enter your password: pass123
Registration successful!
```

### Reservation Process
- When making a reservation, users will be prompted to enter:
  - **Date** of reservation (e.g., 2024-11-15)
  - **Time** of reservation (e.g., 10:00 AM)
  - **Seat Number** (e.g., A1, A2)
  - **Amount to Pay** for the reservation.

If the seat is available and payment is processed, the reservation is confirmed and added to the system.

## Code Structure

- **Main.java**: Entry point of the application that drives the logic of registration, login, reservation, and payment simulation.
- **User.java**: A class to represent a user with attributes like name, contact, email, and password. Includes methods for user authentication.
- **Reservation.java**: Represents a reservation, including reservation ID, user details, seat, and amount paid.
- **ReservationSystem.java**: The core logic that handles seat availability, user registration, login, reservation management, and payment processing.
- **OnlineReservationSystem.java**: Contains the `main()` method that executes the system's command-line interface.

## Example Classes

### User.java
```java
public class User {
    private String name;
    private String contact;
    private String email;
    private String password;
    
    // Constructor, Getters, Setters, and toString methods
}
```

### Reservation.java
```java
public class Reservation {
    private static int reservationCounter = 1001;
    private int reservationId;
    private User user;
    private String date;
    private String time;
    private String seatNumber;
    private double amountPaid;
    
    // Constructor, Getters, Setters, and toString methods
}
```

### ReservationSystem.java
```java
public class ReservationSystem {
    private ArrayList<Reservation> reservations;
    private HashMap<String, ArrayList<String>> seatAvailability;
    private HashMap<String, User> registeredUsers;
    
    // Methods for registration, login, seat availability check, and reservation management
}
```

## Contributing

We welcome contributions to improve this project! To contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Create a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or issues, feel free to open an issue or contact the project maintainers.

- **Author**: [Deepak P]((https://github.com/DeepakPanneerselvam1455/)
