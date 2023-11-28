package Student;

import java.util.Scanner;

public class Main {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;

    private static Student findStudentById(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    private static int findStudentIndexById(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice (0-6): ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        editStudent(scanner);
                        break;
                    case 3:
                        deleteStudent(scanner);
                        break;
                    case 4:
                        sortStudentsByGPA();
                        break;
                    case 5:
                        sortStudentsByName();
                        break;
                    case 6:
                        showStudents();
                        break;
                    case 0:
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 0 to 6.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add student");
        System.out.println("2. Edit student by id");
        System.out.println("3. Delete student by id");
        System.out.println("4. Sort students by GPA");
        System.out.println("5. Sort students by name");
        System.out.println("6. Show students");
        System.out.println("0. Exit");
    }

    private static void addStudent(Scanner scanner) {
        try {
            System.out.println("Enter student details:");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Date of Birth: ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("GPA: ");
            double gpa = scanner.nextDouble();

            if (findStudentById(id) != null) {
                throw new IllegalArgumentException("Student with ID " + id + " already exists.");
            }

            students[studentCount++] = new Student(id, name, dateOfBirth, address, gpa);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    private static void editStudent(Scanner scanner) {
        try {
            System.out.print("Enter student ID to edit: ");
            int idToEdit = scanner.nextInt();

            // Find the index of the student with the given ID
            int indexToEdit = findStudentIndexById(idToEdit);

            if (indexToEdit == -1) {
                throw new IllegalArgumentException("Student with ID " + idToEdit + " not found.");
            }

            System.out.println("Enter new student details:");
            System.out.print("Name: ");
            scanner.nextLine(); // Consume the newline character
            String name = scanner.nextLine();
            System.out.print("Date of Birth: ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("GPA: ");
            double gpa = scanner.nextDouble();

            // Update the student details
            students[indexToEdit] = new Student(idToEdit, name, dateOfBirth, address, gpa);
            System.out.println("Student with ID " + idToEdit + " updated successfully.");
        } catch (Exception e) {
            System.out.println("Error editing student: " + e.getMessage());
        }
    }

    private static void deleteStudent(Scanner scanner) {
        try {
            System.out.print("Enter student ID to delete: ");
            int idToDelete = scanner.nextInt();

            // Find the index of the student with the given ID
            int indexToDelete = findStudentIndexById(idToDelete);

            if (indexToDelete == -1) {
                throw new IllegalArgumentException("Student with ID " + idToDelete + " not found.");
            }

            // Shift elements to fill the gap left by the deleted student
            for (int i = indexToDelete; i < studentCount - 1; i++) {
                students[i] = students[i + 1];
            }

            // Decrement student count
            studentCount--;

            System.out.println("Student with ID " + idToDelete + " deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    private static void sortStudentsByGPA() {

    }

    private static void sortStudentsByName() {
    }

    private static void showStudents() {
    }
}
