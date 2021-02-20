package assignment;
import java.util.Scanner;

public class Class {
  private static final int MAX_STUDENTS = 22;
  private static final int MAX_ASSESMENTS = 50;

  private Student[] students;
  private Assessment[] assessments;
  private String courseName;
  private String courseCode;
  private int numStudents;
  private int numAssessments;

/**
 * Constructor
 */
  
  public Class(String name, String courseCode){ 

    this.courseName = name;
    this.courseCode = courseCode;

    numStudents = 0;
    numAssessments = 0;

    students = new Student[MAX_STUDENTS];
    assessments = new Assessment[MAX_ASSESMENTS];

  } 
   /**
   * Add Student
   */

  public void addStudent(Student student){

    this.students[numStudents] = student;
    numStudents++;

  }


  
   /**
   * Get Course Name
   */

  public String getCourseName() {

    return courseName;

  }

  public String getCourseCode() {

    return courseCode;

  }

   /**
    * Add Assessment
    */
    

    /**
    * Choose Student
    */

    
    /**
    * Choose Assessment
    */
}