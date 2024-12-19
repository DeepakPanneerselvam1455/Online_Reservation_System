import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

class User {
    private String name;
    private String contact;
    private String email;
    private String password;

    public User(String name, String contact, String email, String password) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Contact: " + contact + ", Email: " + email;
    }
}

class Reservation {
    private static int reservationCounter = 1001;
    private int reservationId;
    private User user;
    private String date;
    private String time;
    private String seatNumber;
    private double amountPaid;

    public Reservation(User user, String date, String time, String seatNumber, double amountPaid) {
        this.reservationId = reservationCounter++;
        this.user = user;
        this.date = date;
        this.time = time;
        this.seatNumber = seatNumber;
        this.amountPaid = amountPaid;
    }

    public int getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + "\n" +
                user + "\n" +
                "Date: " + date + ", Time: " + time + ", Seat Number: " + seatNumber + ", Amount Paid: $" + amountPaid;
    }
}

class ReservationSystem {
    private ArrayList<Reservation> reservations;
    private HashMap<String, ArrayList<String>> seatAvailability;
    private HashMap<String, User> registeredUsers;

    public ReservationSystem() {
        reservations = new ArrayList<>();
        seatAvailability = new HashMap<>();
        registeredUsers = new HashMap<>();
        initializeSeatAvailability();
    }

    private void initializeSeatAvailability() {
        seatAvailability.put("2024-11-15", new ArrayList<>(Arrays.asList("A1", "A2", "B1", "B2")));
        seatAvailability.put("2024-11-16", new ArrayList<>(Arrays.asList("A1", "A2", "B1", "B2")));
    }

    public boolean registerUser(String name, String contact, String email, String password) {
        if (registeredUsers.containsKey(email)) {
            System.out.println("User already registered with this email.");
            return false;
        }
        registeredUsers.put(email, new User(name, contact, email, password));
        System.out.println("Registration successful!");
        return true;
    }

    public User loginUser(String email, String password) {
        User user = registeredUsers.get(email);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + user.getName());
            return user;
        }
        System.out.println("Invalid email or password. Please try again.");
        return null;
    }

    public boolean isSeatAvailable(String date, String seatNumber) {
        ArrayList<String> seats = seatAvailability.get(date);
        return seats != null && seats.contains(seatNumber);
    }

    public void reserveSeat(User user, String date, String time, String seatNumber, double amountPaid) {
        if (!isSeatAvailable(date, seatNumber)) {
            System.out.println("Seat " + seatNumber + " is already booked for " + date + ".");
            return;
        }

        Reservation reservation = new Reservation(user, date, time, seatNumber, amountPaid);
        reservations.add(reservation);
        seatAvailability.get(date).remove(seatNumber);
        System.out.println("Reservation successful:\n" + reservation);
    }

    public void viewReservations(User user) {
        boolean found = false;
        for (Reservation res : reservations) {
            if (res.getUser().equals(user)) {
                System.out.println(res);
                System.out.println("---------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No reservations found for this user.");
        }
    }

    public boolean processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + "...");
        System.out.println("Payment successful!");
        return true;
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();
        User loggedInUser = null;

        System.out.println("Welcome to the Online Reservation System");

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. New Reservation");
            System.out.println("4. View My Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    reservationSystem.registerUser(name, contact, email, password);
                    break;

                case 2:
                    System.out.print("Enter your email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    password = scanner.nextLine();
                    loggedInUser = reservationSystem.loginUser(email, password);
                    break;

                case 3:
                    if (loggedInUser == null) {
                        System.out.println("Please login first to make a reservation.");
                        break;
                    }
                    System.out.print("Enter reservation date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter reservation time (e.g., 10:00 AM): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter amount to pay: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    if (reservationSystem.processPayment(amount)) {
                        reservationSystem.reserveSeat(loggedInUser, date, time, seatNumber, amount);
                    }
                    break;

                case 4:
                    if (loggedInUser == null) {
                        System.out.println("Please login first to view reservations.");
                        break;
                    }
                    reservationSystem.viewReservations(loggedInUser);
                    break;

                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
