package Homework1;
import java.util.ArrayList;

public class Student extends People {
    private ArrayList<String> classesCompleted;
    private ArrayList<Subject> enrolledClasses;

    public Student (String name, String role, ArrayList<String> classesComp) {
        super(name, role);
        enrolledClasses = new ArrayList<>();
        classesCompleted = classesComp;
    }

    public Student (String name, String role) {
        super(name, role);
        enrolledClasses = new ArrayList<>();
        classesCompleted = new ArrayList<>();
    }

    public ArrayList<String> getCompletedClasses() {
        return classesCompleted;
    }

    public ArrayList<Subject> getEnrolledClasses() {
        return enrolledClasses;
    }

    public void enroll(Subject a) {
        String prereq = a.getPrereq();
        if (!classesCompleted.contains(prereq) && prereq != null) {
            System.out.println("You have not completed the prerequiste class, " + a.getPrereq() + ", needed in order to enroll in this course.");
        }
        else if (a.getPeopleEnrolled() == a.getMax()) {
            System.out.println("This class is full.");
        }
        else {
            enrolledClasses.add(a);
            System.out.println(getName() + "'s Enrolled Courses: ");
            for (Subject sub : enrolledClasses) {
                System.out.println(sub.getName());
            }
        }
    }
}
