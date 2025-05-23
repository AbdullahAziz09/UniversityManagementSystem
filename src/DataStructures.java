// DataStructures.java

import java.util.*;

public class DataStructures {
    // Using HashMap to store students (key: id)
    public static HashMap<Integer, Student> students = new HashMap<>();

    // HashMap for faculty
    public static HashMap<Integer, Faculty> faculty = new HashMap<>();

    // ArrayList to store courses
    public static ArrayList<Course> courses = new ArrayList<>();

    // LinkedList to store enrollment history
    public static LinkedList<Enrollment> enrollments = new LinkedList<>();

    // Stack to track last enrollments (for undo feature)
    public static Stack<Enrollment> recentEnrollments = new Stack<>();

    // Queue to register students in order
    public static Queue<Student> registrationQueue = new LinkedList<>();

    // HashSet to prevent duplicate courses
    public static HashSet<String> courseCodes = new HashSet<>();

    // TreeMap to sort courses by name
    public static TreeMap<String, Course> sortedCourses = new TreeMap<>();

    // PriorityQueue to track most enrolled courses
    public static PriorityQueue<Course> topCourses = new PriorityQueue<>(
        (a, b) -> Integer.compare(b.enrolled, a.enrolled) // Descending by enrolled count
    );
}
