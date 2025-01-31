import java.util.ArrayList;

public class Students extends People {
    private ArrayList<String> classesCompleted;
    private ArrayList<Subject> enrolledSubjects;

    public Students (String name, String role, ArrayList<Subject> classesCompleted) {
        super(name, role);
        enrolledSubjects = new ArrayList<>();
        classesCompleted = new ArrayList<>();
    }

    public Students (String name, String role) {
        super(name, role);
        enrolledSubjects = new ArrayList<>();
        classesCompleted = null;
    }

    public void getCompletedClasses() {
        for (String c : classesCompleted) {
            System.out.print(c + ", ");
        }
    }

    public void getEnrolledClasses() {
        for (Subject e : enrolledSubjects) {
            System.out.print(e + ", ");
        }
    }

    public void enroll(Subject a) {
        if (!classesCompleted.contains(a.getPrereq())) {
            System.out.println("You have not completed the prerequiste class, " + a.getPrereq() + ", needed in order to enroll in this course.");
        }
        else if (a.getPeopleEnrolled() == a.getMax()) {
            System.out.println("This class is full.");
        }
        else {
            enrolledSubjects.add(a);
            System.out.println(getName() + "'s Enrolled Courses: ");
            for (Subject sub : enrolledSubjects) {
                System.out.println(sub);
            }
        }
    }
}
