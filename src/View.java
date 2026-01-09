public class View {


    public View(Model model) {

    }

    private int index = 1;
    boolean firstIntro = true;

    public void printAllStudents(Model model) {
        if (model.getStudentList() != null) {
            for (Student s : model.getStudentList()) {
                System.out.println(index + ". " + s.getFirstName() + " " + s.getLastName());
                index++;
            }
            System.out.println(index + ". Exit");
            index = 1;
        } else {
            System.out.println("No students exist.");
        }
    }

    public void printAllCourses(Model model) {
        for (Course c : model.getCourses()) {
            System.out.println(index + ". " + c.getCourseName());
            index++;
        }
        System.out.println(index + ". Exit");
        index = 1;
    }

    public void printAllTeachers(Model model) {
        if (model.getTeacherList() != null) {
            for (Teacher t : model.getTeacherList()) {
                System.out.println(index + ". " + t.getFirstName() + " " + t.getLastName());
                index++;
            }
            System.out.println(index + ". Exit");
            index = 1;
        } else {
            System.out.println("No teachers exist.");
        }
    }

    public void printCourseInfo(Course course) {
        System.out.println(course.getCourseName());
        if (course.getTeacher() != null) {
            System.out.println("Teacher: " + course.getTeacher().getFirstName() + " " + course.getTeacher().getLastName());
        } else {
            System.out.println("No teacher assigned");
        }
        if (!course.getClassList().isEmpty()) {
            for (Student s : course.getClassList()) {
                System.out.println(index + ". " + s.getFirstName() + " " + s.getLastName());
                index++;
            }
            System.out.println("--------------------");
            index = 1;
        } else {
            System.out.println("Course is empty, add students.");
        }
    }

    public void printCourseStudents(Course course){
        if (!course.getClassList().isEmpty()) {
            for (Student s : course.getClassList()) {
                System.out.println(index + ". " + s.getFirstName() + " " + s.getLastName() + " " + s.getGrade(course));
                index++;
            }
            index = 1;
        } else {
            System.out.println("Course is empty, add students.");
        }
    }

    public void printStudentInfo(Student student) {
        System.out.println("Selected student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Student email: " + student.getEmailAddress());

    }

    public void printTeacherInfo(Teacher teacher) {
        System.out.println("Selected Teacher: " + teacher.getFirstName() + " " + teacher.getLastName());
        System.out.println("Teacher's email: " + teacher.getEmailAddress());

    }

    public void printMessage(String messageText) {
        System.out.println(messageText);

    }

    public void printOnOneLine(String messageText){
        System.out.print(messageText);
    }

    public void printIntro() throws InterruptedException {

        if (firstIntro) {
            int sleepAmount = 650;
            System.out.println("\n\n\n");
            System.out.println("▄▖  ▌     ▜              ");
            Thread.sleep(sleepAmount);
            System.out.println("▚ ▛▘▛▌▛▌▛▌▐              ");
            Thread.sleep(sleepAmount);
            System.out.println("▄▌▙▖▌▌▙▌▙▌▐▖             ");
            System.out.println("                         ");
            Thread.sleep(sleepAmount);
            System.out.println("▄▖ ▌   ▘    ▄▖    ▗      ");
            Thread.sleep(sleepAmount);
            System.out.println("▌▌▛▌▛▛▌▌▛▌▄▖▚ ▌▌▛▘▜▘█▌▛▛▌");
            Thread.sleep(sleepAmount);
            System.out.println("▛▌▙▌▌▌▌▌▌▌  ▄▌▙▌▄▌▐▖▙▖▌▌▌");
            Thread.sleep(sleepAmount);
            System.out.println("              ▄▌         ");
            Thread.sleep(sleepAmount);
            System.out.println();
            firstIntro=false;
        } else {
            System.out.println("\n\n\n");
            System.out.println("▄▖  ▌     ▜              ");
            System.out.println("▚ ▛▘▛▌▛▌▛▌▐              ");
            System.out.println("▄▌▙▖▌▌▙▌▙▌▐▖             ");
            System.out.println("                         ");
            System.out.println("▄▖ ▌   ▘    ▄▖    ▗      ");
            System.out.println("▌▌▛▌▛▛▌▌▛▌▄▖▚ ▌▌▛▘▜▘█▌▛▛▌");
            System.out.println("▛▌▙▌▌▌▌▌▌▌  ▄▌▙▌▄▌▐▖▙▖▌▌▌");
            System.out.println("              ▄▌         ");
            System.out.println();
            Thread.sleep(500);
        }

    }

    public void studentFindCourses(Student student, Model model) {
        int index = 1;
        boolean studentHasCourse = false;
        for (Course c : model.courses) {
            if (c.getClassList().contains(student)) {
                studentHasCourse = true;
            }
        }
        if (studentHasCourse) {
            System.out.println(student.getFirstName() + " is enrolled in: ");
            for (Course c : model.courses) {
                if (c.getClassList().contains(student)) {
                    System.out.println(index + ". " + c.getCourseName() + " " + student.getGrade(c));
                    index++;
                }
            }
            System.out.println("-------------");
        } else {
            System.out.println("Student has no courses.\n");
        }
    }
}
