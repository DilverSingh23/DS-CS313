import java.util.Arrays;
import java.util.ArrayList;

public class CunyEnrollment {
    public static void main (String[] args) {
        CSDepartment csDept = new CSDepartment();

        Subject cs111 = new Subject("CS111", 0, 30);
        Subject cs112 = new Subject("CS112", 15, 35);
        Subject cs120 = new Subject("CS120", 12, 25);

        Subject cs211 = new Subject("CS211", "CS111", 18, 30);
        Subject cs212 = new Subject("CS212", "CS211", 15, 25);
        Subject cs220 = new Subject("CS220", "CS111", 20, 35);

        Subject cs313 = new Subject("CS313", "CS120", 25, 27);
        Subject cs320 = new Subject("CS320", "CS212", 30, 30);
        Subject cs340 = new Subject("CS340", "CS212", 28, 28);

        Subject cs343 = new Subject("CS343", "CS212", 10, 25);
        Subject cs355 = new Subject("CS355", "CS211", 22, 35);
        Subject cs370 = new Subject("CS370", "CS313", 15, 30);

        csDept.addSubjects(cs111);
        csDept.addSubjects(cs112);
        csDept.addSubjects(cs120);
        csDept.addSubjects(cs211);
        csDept.addSubjects(cs212);
        csDept.addSubjects(cs220);
        csDept.addSubjects(cs313);
        csDept.addSubjects(cs320);
        csDept.addSubjects(cs340);
        csDept.addSubjects(cs343);
        csDept.addSubjects(cs355);
        csDept.addSubjects(cs370);

        ArrayList<String> completed1 = new ArrayList<>(Arrays.asList(cs111.getName(), cs112.getName(), cs120.getName()));
        ArrayList<String> completed2 = new ArrayList<>(Arrays.asList(cs111.getName(), cs211.getName(), cs212.getName()));
        ArrayList<String> completed3 = new ArrayList<>(Arrays.asList(cs111.getName(), cs120.getName(), cs211.getName(), cs212.getName(), cs313.getName()));

        Student student1 = new Student("John Doe", "Student", completed1);
        Student student2 = new Student("Paul James", "Student", completed2);
        Student student3 = new Student("Dilver Singh", "Student", completed3);

        ArrayList<Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3));

        for (int i = 0; i < students.size(); i++) {
            students.get(i).enroll(cs120);
            students.get(i).enroll(cs340);
            students.get(i).enroll(cs370);
        }



    }
}
