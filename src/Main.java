import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.loadFromFile();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    try {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        Student newStudent = new Student(id, name, age, course);
                        manager.addStudent(newStudent);
                        System.out.println("Student added successfully!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! ID and Age must be numbers.");
                    }
                    break;

                case "2":
                    manager.viewStudents();
                    break;

                case "3":
                    try {
                        System.out.print("Enter ID to search: ");
                        int searchId = Integer.parseInt(sc.nextLine());
                        Student foundStudent = manager.searchStudent(searchId);
                        if (foundStudent != null) {
                            System.out.println("Found Student - ID: " + foundStudent.getId() + ", Name: " + foundStudent.getName() + ", Age: " + foundStudent.getAge() + ", Course: " + foundStudent.getCourse());
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! ID must be a number.");
                    }
                    break;

                case "4":
                    try {
                        System.out.print("Enter ID to update: ");
                        int updateId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new Age: ");
                        int newAge = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new Course: ");
                        String newCourse = sc.nextLine();

                        Student updatedStudent = manager.updateStudent(updateId, newAge, newCourse);
                        if (updatedStudent != null) {
                            System.out.println("Student updated successfully!");
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! ID and Age must be numbers.");
                    }
                    break;

                case "5":
                    try {
                        System.out.print("Enter ID to delete: ");
                        int deleteId = Integer.parseInt(sc.nextLine());
                        boolean deleted = manager.deleteStudent(deleteId);
                        if (deleted) {
                            System.out.println("Student deleted successfully!");
                        } else {
                            System.out.println("Student not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! ID must be a number.");
                    }
                    break;

                case "6":
                    manager.saveToFile();
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Feature not connected yet.");
            }
        }
    }
}