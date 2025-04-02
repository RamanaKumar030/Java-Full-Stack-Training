package DAY23;


import java.util.*;

// Student class with name and marks
class Student {
    private String name;
    private int marks;

    // Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    // Display method
    public void display() {
        System.out.println(name + ": " + marks);
    }
}

public class Anonymous {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 90),
            new Student("Charlie", 78)
        );

        // Sorting using an anonymous inner class
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMarks(), s1.getMarks()); // Sorting in descending order
            }
        });

        // Display sorted list
        System.out.println("Students sorted by marks (Descending Order):");
        for (Student s : students) {
            s.display();
        }
    }
}
