

import java.util.ArrayList;

class Person {
    protected String name;
    protected int age;
    protected String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}



class Student extends Person {
    private String studentId;

    public Student(String name, int age, String gender, String studentId) {
        super(name, age, gender);
        this.studentId = studentId;
    }

    public void displayStudent() {
        System.out.println("---Student Information---");
        displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println();
    }
}


class Course {
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void displayCourse() {
        System.out.println(courseCode + " " + courseName);
    }
}


class Teacher extends Person {
    private String department;
    private ArrayList<Course> courses; // aggregation (Teacher HAS-A Course)

    public Teacher(String name, int age, String gender, String department) {
        super(name, age, gender);
        this.department = department;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayTeacher() {
        System.out.println("---Teacher Information---");
        displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Courses Handled:");
        for (Course c : courses) {
            c.displayCourse();
        }
        System.out.println();
    }
}


public class TeacherStudentAssignment_updated {
    public static void main(String[] args) {


        Student s1 = new Student("Ana Santos", 19, "Female", "51023");
        s1.displayStudent();


        Course c1 = new Course("CS101", "Programming Fundamentals");
        Course c2 = new Course("CS102", "Object-Oriented Programming");


        Teacher t1 = new Teacher("Mr. Dela Cruz", 45, "Male", "Computer Studies");
        t1.addCourse(c1);
        t1.addCourse(c2);
        t1.displayTeacher();


        System.out.println("Displaying the course");
        c1.displayCourse();
    }
}