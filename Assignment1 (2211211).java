import java.util.*;

class Student {
    int id;
    String fname;
    double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
}

class CGPACompare implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int cgpaCompare = Double.compare(s2.cgpa, s1.cgpa);
        if (cgpaCompare != 0) {
            return cgpaCompare;
        } else {
            return s1.fname.compareTo(s2.fname);
        }
    }
}

public class Assignment1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("No of cases? ");
        int testCases = Integer.parseInt(in.nextLine());

        System.out.println("Enter all cases ");
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            studentList.add(new Student(id, fname, cgpa));
        }

        Collections.sort(studentList, new CGPACompare());

        System.out.println("Output order: ");
        for (Student student : studentList) {
            System.out.println(student.fname + " "+"(CGPA - " +student.cgpa+")");
        }
    }
}