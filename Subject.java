public class Subject {
    private String name;
    private String prereq;
    private int peopleEnrolled;
    private int max;

    public Subject (String n, String p, int pe, int m) {
        name = n;
        prereq = p;
        peopleEnrolled = pe;
        max = m;
    }

    public Subject (String n, int pe, int m) {
        name = n;
        prereq = null;
        peopleEnrolled = pe;
        max = m;
    }

    public String getName () {
        return name;
    }

    public String getPrereq() {
        return prereq;
    }

    public int getPeopleEnrolled () {
        return peopleEnrolled;
    }

    public int getMax () {
        return max;
    }
}
