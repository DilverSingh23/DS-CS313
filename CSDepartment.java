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

    public void removeSubjects (Subject b) {
        subjects.remove(b);
    }

    public boolean checkSubject (String c) {
        for (int i = 0; i < subjects.size(); i++) {
            if ((subjects.get(i)).getName().equals(c)) {
                return true;
            }
        }
        return false;
    }

    public Subject makeSubject (String a) {
        for (int i = 0; i < subjects.size(); i++) {
            Subject newSubject = subjects.get(i);
            if (newSubject.getName().equals(a)) {
                return newSubject;
            }
        }
        return null;
    }

    public void displaySubjects () {
        System.out.println("Available classes: ");
        for (Subject sub : subjects) {
            System.out.print(sub.getName() + ",");
        }
    }
}
