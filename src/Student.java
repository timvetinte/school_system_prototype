import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private int studentID;
    private List<Grade> grades;

    public Student(String firstName, String lastName, String emailAddress, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.studentID = studentID;
        this.grades = new ArrayList<>();
    }

    public static Student createStudent(String firstName, String lastName, String emailAddress, int studentID) {
        return new Student(firstName, lastName, emailAddress, studentID);
    }

    public void addGrade(Course course, String grade) {
        for (Grade g : grades) {
            if (g.getCourse().equals(course)) {
                g.setGrade(grade);
                return;
            }
        }
        Grade newGrade = new Grade(course, grade);
        grades.add(newGrade);
    }

    public String getGrade(Course course) {
        for (Grade grade : grades) {
            if (grade.getCourse().equals(course)) {
                return "(" + grade.getGrade() + ")";
            }
        }
        return "(-)";
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
