import java.util.ArrayList;

public class CSDepartment extends QueensCollege {
    private ArrayList<Subject> subjects;

    public CSDepartment () {
        super();
        subjects = new ArrayList<>();
    }

    public void addSubjects (Subject a) {
        subjects.add(a);
    }

    public void displaySubjects () {
        System.out.println("Available classes: ");
        for (Subject sub : subjects) {
            System.out.print(sub + ",");
        }
    }
}
