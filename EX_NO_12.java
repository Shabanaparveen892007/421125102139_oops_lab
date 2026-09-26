OFFLINE TIMETABLE SYSTEM – PROGRAM
import java.util.Scanner;
 
// Parent Class
class Timetable {
 
    private String day;
    private String time;
    private String subject;
    private String faculty;
    private String room;
 
    // Constructor
    Timetable(String day, String time, String subject,
              String faculty, String room) {
        this.day = day;
        this.time = time;
        this.subject = subject;
        this.faculty = faculty;
        this.room = room;
    }
 
    // Getters
    String getDay() {
        return day;
    }
 
    String getTime() {
        return time;
    }
 
    String getSubject() {
        return subject;
    }
 
    // Display method
    void display() {
        System.out.println(
            day + " | " + time + " | " +
            subject + " | " + faculty + " | " + room
        );
    }
 
    // Update method
    void update(String time, String subject,
                String faculty, String room) {
        this.time = time;
        this.subject = subject;
        this.faculty = faculty;
        this.room = room;
    }
}
 
 
// Child Class
class ClassTimetable extends Timetable {
 
    private String className;
 
    ClassTimetable(String day, String time, String subject,
                   String faculty, String room,
                   String className) {
 
        super(day, time, subject, faculty, room);
        this.className = className;
    }
 
    // Method Overriding
    @Override
    void display() {
        System.out.println(className + " | ");
        super.display();
    }
}
 
 
// Main Class
public class OfflineTimetableSystem {
 
    static Scanner sc = new Scanner(System.in);
 
    static Timetable[] timetable = new Timetable[50];
 
    static int count = 0;
 
 
    // Add timetable
    static void addTimetable() {
 
        System.out.println("\n--- ADD TIMETABLE ---");
 
        System.out.print("Enter Day: ");
        String day = sc.nextLine();
 
        System.out.print("Enter Time: ");
        String time = sc.nextLine();
 
        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();
 
        System.out.print("Enter Faculty Name: ");
        String faculty = sc.nextLine();
 
        System.out.print("Enter Room No: ");
        String room = sc.nextLine();
 
        timetable[count] =
            new Timetable(day, time, subject, faculty, room);
 
        count++;
 
        System.out.println("Timetable added successfully!");
    }
 
 
    // View timetable
    static void viewTimetable() {
 
        System.out.println("\n--------- TIMETABLE ---------");
 
        if (count == 0) {
            System.out.println("No timetable available.");
            return;
        }
 
        System.out.println(
            "Day | Time | Subject | Faculty | Room"
        );
 
        System.out.println(
            "-------------------------------------------"
        );
 
        for (int i = 0; i < count; i++) {
            timetable[i].display();
        }
    }
 
 
    // Search timetable
    static void searchTimetable() {
 
        System.out.println("\n--- SEARCH TIMETABLE ---");
 
        System.out.print("Enter Day to Search: ");
        String searchDay = sc.nextLine();
 
        boolean found = false;
 
        for (int i = 0; i < count; i++) {
 
            if (timetable[i].getDay()
                    .equalsIgnoreCase(searchDay)) {
 
                timetable[i].display();
                found = true;
            }
        }
 
        if (!found) {
            System.out.println(
                "No timetable found for " + searchDay
            );
        }
    }
 
 
    // Update timetable
    static void updateTimetable() {
 
        System.out.println("\n--- UPDATE TIMETABLE ---");
 
        System.out.print("Enter Day: ");
        String day = sc.nextLine();
 
        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();
 
        boolean found = false;
 
        for (int i = 0; i < count; i++) {
 
            if (timetable[i].getDay()
                    .equalsIgnoreCase(day)
                &&
                timetable[i].getSubject()
                    .equalsIgnoreCase(subject)) {
 
                System.out.print("Enter New Time: ");
                String time = sc.nextLine();
 
                System.out.print("Enter New Subject: ");
                String newSubject = sc.nextLine();
 
                System.out.print("Enter New Faculty: ");
                String faculty = sc.nextLine();
 
                System.out.print("Enter New Room: ");
                String room = sc.nextLine();
 
                timetable[i].update(
                    time, newSubject, faculty, room
                );
 
                System.out.println(
                    "Timetable updated successfully!"
                );
 
                found = true;
                break;
            }
        }
 
        if (!found) {
            System.out.println("Timetable not found.");
        }
    }
 
 
    // Delete timetable
    static void deleteTimetable() {
 
        System.out.println("\n--- DELETE TIMETABLE ---");
 
        System.out.print("Enter Day: ");
        String day = sc.nextLine();
 
        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();
 
        boolean found = false;
 
        for (int i = 0; i < count; i++) {
 
            if (timetable[i].getDay()
                    .equalsIgnoreCase(day)
                &&
                timetable[i].getSubject()
                    .equalsIgnoreCase(subject)) {
 
                for (int j = i; j < count - 1; j++) {
                    timetable[j] = timetable[j + 1];
                }
 
                timetable[count - 1] = null;
                count--;
 
                System.out.println(
                    "Timetable deleted successfully!"
                );
 
                found = true;
                break;
            }
        }
 
        if (!found) {
            System.out.println("Timetable not found.");
        }
    }
 
 
    // Main method
    public static void main(String[] args) {
 
        int choice;
 
        do {
 
            System.out.println("\n==============================");
            System.out.println("   OFFLINE TIMETABLE SYSTEM");
            System.out.println("==============================");
 
            System.out.println("1. Add Timetable");
            System.out.println("2. View Timetable");
            System.out.println("3. Search Timetable");
            System.out.println("4. Update Timetable");
            System.out.println("5. Delete Timetable");
            System.out.println("6. Exit");
 
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
 
            switch (choice) {
 
                case 1:
                    addTimetable();
                    break;
 
                case 2:
                    viewTimetable();
                    break;
 
                case 3:
                    searchTimetable();
                    break;
 
                case 4:
                    updateTimetable();
                    break;
 
                case 5:
                    deleteTimetable();
                    break;
 
                case 6:
                    System.out.println(
                        "Thank you for using Offline Timetable System!"
                    );
                    break;
 
                default:
                    System.out.println(
                        "Invalid choice. Try again."
                    );
            }
 
        } while (choice != 6);
 
        sc.close();
    }
}
