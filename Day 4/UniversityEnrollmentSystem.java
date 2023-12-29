
package placement_training;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class Student extends Person {
    private int studentId;
    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }
    public int getStudentId() {
        return studentId;
    }
}
class Professor extends Person {
    private int employeeId;
    public Professor(String name, int age, int employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }
    public int getEmployeeId() {
        return employeeId;
    }
}
class Course {
    private String courseName;
    private List<Course> prerequisites;
    private List<Student> enrolledStudents;
    public Course(String courseName) {
        this.courseName = courseName;
        this.prerequisites = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }
    public String getCourseName() {
        return courseName;
    }
    public void addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
    }
    public void enrollStudent(Student student) {
        if (hasCompletedPrerequisites(student)) {
            enrolledStudents.add(student);
            System.out.println("Student " + student.getName() + " enrolled in " + courseName);
        } else {
            System.out.println("Student " + student.getName() + " cannot be enrolled in " + courseName
                    + " due to incomplete prerequisites.");
        }
    }
    private boolean hasCompletedPrerequisites(Student student) {
        for (Course prerequisite : prerequisites) {
            if (!studentHasCompletedCourse(student, prerequisite)) {
                return false;
            }
        }
        return true;
    }
    private boolean studentHasCompletedCourse(Student student, Course course) {
        return true;
    }
    public void displayEnrolledStudents() {
        System.out.println("Enrolled Students in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("Student ID: " + student.getStudentId() + ", Name: " + student.getName());
        }
    }
}
public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Student student1 = new Student("Leo Messi", 20, 1001);
        Student student2 = new Student("Ramkishan", 22, 1002);
        Professor professor1 = new Professor("Dr. Premz", 40, 2001);
        Course math101 = new Course("Math 101");
        Course physics101 = new Course("Physics 101");
        math101.addPrerequisite(physics101);
        math101.enrollStudent(student1);
        math101.enrollStudent(student2);
        physics101.enrollStudent(student1);
        math101.displayEnrolledStudents();
        physics101.displayEnrolledStudents();
    }
}
