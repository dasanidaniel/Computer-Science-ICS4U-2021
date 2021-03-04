package assignment;

public class Student {
  private String firstName;
  private String lastName;
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

  public String getName() {
    return lastName + "," + firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCohort() {
  	return cohort;
  }

//Testing

}
