package gradebook2;

public class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseCode, String courseName) {

        this.courseCode = courseCode;
        this.courseName = courseName;

    }

    public String getcourseCode(){
        return courseCode;
    }

    public String getcourseName(){
        return courseName;
    }
}


