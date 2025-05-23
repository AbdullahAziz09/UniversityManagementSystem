// Main.java

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== University Course Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Faculty");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student");
            System.out.println("5. Show All Courses");
            System.out.println("6. Show Enrollments");
            System.out.println("7. Undo Last Enrollment");
            System.out.println("8. Show Sorted Courses");
            System.out.println("9. Show Top Enrolled Courses");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addFaculty();
                case 3 -> addCourse();
                case 4 -> enrollStudent();
                case 5 -> showCourses();
                case 6 -> showEnrollments();
                case 7 -> undoEnrollment();
                case 8 -> showSortedCourses();
                case 9 -> showTopCourses();
                case 10 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 10);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student s = new Student(id, name);
        DataStructures.students.put(id, s); // add to map
        System.out.println("Student added.");
    }

    static void addFaculty() {
        System.out.print("Enter Faculty ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Faculty Name: ");
        String name = sc.nextLine();

        Faculty f = new Faculty(id, name);
        DataStructures.faculty.put(id, f);
        System.out.println("Faculty added.");
    }

    static void addCourse() {
        sc.nextLine();
        System.out.print("Enter Course Code: ");
        String code = sc.nextLine();
        if (DataStructures.courseCodes.contains(code)) {
            System.out.println("Course already exists.");
            return;
        }
        System.out.print("Enter Course Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Max Students: ");
        int max = sc.nextInt();

        Course c = new Course(code, title, max,max);
        DataStructures.courses.add(c);
        DataStructures.courseCodes.add(code);
        DataStructures.sortedCourses.put(title, c);
        DataStructures.topCourses.add(c);
        System.out.println("Course added.");
    }

    static void enrollStudent() {
        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        System.out.print("Enter Course Code: ");
        sc.nextLine();
        String ccode = sc.nextLine();

        Student s = DataStructures.students.get(sid);
        Course c = null;
        for (Course course : DataStructures.courses) {
            if (course.code.equals(ccode)) {
                c = course;
                break;
            }
        }

        if (s != null && c != null && c.enrolled < c.maxStudents) {
            c.enrollStudent();
            Enrollment e = new Enrollment(s, c);
            DataStructures.enrollments.add(e);
            DataStructures.recentEnrollments.push(e); // Add to stack
            DataStructures.topCourses.remove(c);
            DataStructures.topCourses.add(c); // Re-add to update priority
            System.out.println("Enrollment successful.");
        } else {
            System.out.println("Enrollment failed.");
        }
    }

    static void showCourses() {
        for (Course c : DataStructures.courses) {
            System.out.println(c);
        }
    }

    static void showEnrollments() {
        for (Enrollment e : DataStructures.enrollments) {
            System.out.println(e);
        }
    }

    static void undoEnrollment() {
        if (!DataStructures.recentEnrollments.isEmpty()) {
            Enrollment last = DataStructures.recentEnrollments.pop();
            last.course.enrolled--;
            DataStructures.enrollments.remove(last);
            DataStructures.topCourses.remove(last.course);
            DataStructures.topCourses.add(last.course);
            System.out.println("Last enrollment undone: " + last);
        } else {
            System.out.println("No enrollment to undo.");
        }
    }

    static void showSortedCourses() {
        for (String title : DataStructures.sortedCourses.keySet()) {
            System.out.println(DataStructures.sortedCourses.get(title));
        }
    }

    static void showTopCourses() {
        System.out.println("Top Enrolled Courses:");
        for (Course c : DataStructures.topCourses) {
            System.out.println(c);
        }
    }
}
