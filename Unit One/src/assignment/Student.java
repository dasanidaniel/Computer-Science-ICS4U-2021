package assignment;

public class Student {
  private static String firstName;
  private static String lastName;
  private String cohort;
  private int grade;


  public Student(String firstName, String lastName, int grade, String cohort) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.grade = grade;
    this.cohort = cohort;
  }


public int getGrade() {
	return grade;
}


public static String getName() {
	return lastName + "," + firstName;
}


public String getCohort() {
	return cohort;
}

//Testing

}
