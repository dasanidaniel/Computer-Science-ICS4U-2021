package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
 
private static final int MAX_CLASSES = 50;
private static final int MAX_STUDENTS = 1000;
private static final int MAX_QUESTIONS = 10000;

private static QuestionBank qBank;
private static Student[] students;  
private static Class[] classes;
private static Question[] questions;  
private static int numClasses = 0;
private static int numStudents = 0;
private static int numQuestions = 0;

public Driver(){

  qBank = new QuestionBank("src\\assignment\\questionBank.dat");

  /**
   * Create a list of students (Load from a file)
   */

  loadAllStudents("src\\assignment\\students.dat");

  /**
   * Create a list of classes (Load from a file)
   */

  loadAllClasses("src\\assignment\\courses.dat");
   
  /**
   * Create a list of questions (Load from a file)
  */

  loadAllQuestions("src\\assignment\\QuestionBank.dat");
   
}

public static void main(String[] args) {
  
  Driver driver = new Driver();

  boolean done = false;
  
  Scanner in = new Scanner(System.in);

  while (!done) {
    displayMenu();
    int option = Integer.parseInt(in.nextLine());

    if (option == 1){
      addClass(in);
    }

    else if (option == 2){
      addStudent(in);
    }

    else if (option == 3){
      assignStudentClass();
    }

    else if (option == 4){
      addQuestion(in);
    }
    
    else if (option == 13){
      displayAllClassses(classes);
    }

    else if (option == 11){
      studentsByGrade(in);
    }

    else if (option == 12){
      studentsByCohort(in);
    }

    else if (option == 14){
      displayAllStudents(students);
    }

    else if (option == 15){
      displayAllQuestions(questions);
    }

  }


    /**
     * 
    else if (option == 3){
      assignStudentClass();
    }

    else if (option == 4){
      addQuestion();
    }

  }


    else if (option == 5){
      Class.newAssessment(); //Fix this later
    }

    else if (option == 6){
      allowStudent();
    }

    else if (option == 7){
      averageByStudent();
    }

  }
  
  */
}



  private static void displayMenu() {

  System.out.println();
  System.out.println("LEDSBY - School Software");
  System.out.println();
  System.out.println("1. Create Class");
  System.out.println("2. Create Student");
  System.out.println("3. Assign Student to Class");
  System.out.println("4. Create Question");
  System.out.println("5. Create a new Assignmnent for a Class");
  System.out.println("5a. Choose Questions for Assignment");
  System.out.println("6. Allow Student to Take Test from Class");
  System.out.println("7. Allow Student to Take Test from Class");
  System.out.println("13. Display All Claasses");
  System.out.println("14. Display All Students");
  System.out.println("15. Display All Questions");
  System.out.println();
  System.out.println("______________________________");
  System.out.println();

  }



  // MENU 1
  private static void addClass(Scanner scanner) {
  
    System.out.println();
    System.out.println("Create Class");
    System.out.println();
    System.out.println("______________________________");
    System.out.println();
   
    System.out.println();
    System.out.println("Course Name:");
    
    String courseName = scanner.nextLine();
      
    System.out.println();
    System.out.println("Course Code:");
    
    String courseCode = scanner.nextLine();
    
    Class f = new Class (courseName, courseCode);
    classes[numClasses] = f;
    numClasses++;
    
  }



  // MENU 2
  private static void addStudent(Scanner scanner) {
  
    System.out.println();
    System.out.println("Create Student");
    System.out.println();
    System.out.println("______________________________");
    System.out.println();

  
    System.out.println();
    System.out.println("First Name:");

    String firstName = scanner.nextLine();

    System.out.println();
    System.out.println("Last Name:");

    String lastName = scanner.nextLine();

    System.out.println();
    System.out.println("Grade:");

    int grade = Integer.parseInt(scanner.nextLine()); 

    System.out.println();
    System.out.println("Cohort:");

    String cohort = scanner.nextLine();
  
    Student f = new Student (firstName, lastName, grade, cohort);
    students[numStudents] = f;
    numStudents++;
  
  }

  // MENU 3
  private static void assignStudentClass() {

    System.out.println();
    System.out.println("Assign a Student to a Class");
    System.out.println();
    System.out.println("______________________________");
    System.out.println();
    System.out.println("Student First Name:");
    
    Scanner scanner = new Scanner(System.in);
    
    String firstNameStudent = scanner.nextLine();
    
    System.out.println();
    System.out.println("Student Last Name:");
    
    String lastNameStudent = scanner.nextLine();
    
    String studentFullName = lastNameStudent + "," + firstNameStudent; 
    
    for (int i = 0; i < numStudents; i++) {
    
      if (studentFullName.equals(Student.getName())) {
    
        System.out.println();
        System.out.println("Desired Course Code:");
        
        String courseCode = scanner.nextLine();
          
        for (int j = 0; j < numClasses; i++) {
    
          Class c = classes[j];
    
        }
    
    
      }
    
    }
    
  }

  // MENU 4         
  private static void addQuestion(Scanner scanner) {

    System.out.println();
    System.out.println("Add Question to Question Bank");
    System.out.println();
	  System.out.println("______________________________");
	  System.out.println();
    System.out.println("Question:");

    String question = scanner.nextLine();

    System.out.println();
    System.out.println("Answer:");

    int answer = Integer.parseInt(scanner.nextLine()); 

    System.out.println();
    System.out.println("Marks:");

    int marks = Integer.parseInt(scanner.nextLine()); 

    Question f = new Question(question, answer, marks); 
    questions[numQuestions] = f;
    numQuestions++;

}



  // MENU 11
  private static void studentsByGrade(Scanner scanner) {

    int grade = Integer.parseInt(scanner.nextLine()); 

    for (Student s : students){

      if (s.getGrade() == grade){
        System.out.println(s.getName());

      }
  }
}


  // MENU 12
  private static void studentsByCohort (Scanner scanner) {

  String cohort = scanner.nextLine();

  for (Student s : students){

    
    if (s.getCohort().equals(cohort)){
      System.out.println(s.getName());
    }
  }
}


  // MENU 13
  private static void displayAllClassses(Class[] classes) {

  System.out.println();
  System.out.println("______________________________");

    for (Class x : classes) {
      if (x != null) {

      System.out.println();
      System.out.println(x.getCourseName());
      System.out.println(x.getCourseCode());


    }

  }

  System.out.println("______________________________");
  System.out.println();

  }


  // MENU 14
  private static void displayAllStudents(Student[] students) {

    for (Student x : students) {
      if (x != null) {
      
      System.out.println();
      System.out.println(Student.getName());
      System.out.println(x.getGrade());
      System.out.println(x.getCohort());


    }
  }

  System.out.println("______________________________");
  System.out.println();
  
  }  
  
  
  // MENU 15
  private static void displayAllQuestions(Question[] questions) {

    for (Question x : questions) {
      if (x != null) {
      
      System.out.println();
      System.out.println(x.getQuestion());
      System.out.println(x.getAnswer());
      System.out.println(x.getMarks());


    }
  }

  System.out.println("______________________________");
  System.out.println();
  
  }
  


  private static void loadAllClasses(String fileName) {
    classes = new Class[MAX_CLASSES];

    try{

      Scanner scanner = new Scanner(new File(fileName));
     
      while(scanner.hasNextLine()){
        String name = scanner.nextLine().split(":")[1].trim();
        String courseCode = scanner.nextLine().split(":")[1].trim();
  
        Class f = new Class(name, courseCode);
        classes[numClasses] = f;
        numClasses++;
      }
    }
    
    catch(FileNotFoundException ex){
      System.out.println("FILE NOT FOUND");
    }
  }
  

  
  private static void loadAllStudents(String string) {
    students = new Student[MAX_STUDENTS];
  
  try {
  
    Scanner scanner = new Scanner(new File(string));
    int numStudents = 0;
    
    while(scanner.hasNextLine()){
      String firstName = scanner.nextLine().split(":")[1].trim();
      String lastName = scanner.nextLine().split(":")[1].trim();
      int grade = Integer.parseInt(scanner.nextLine().split(":")[1].trim());
      String cohort = scanner.nextLine().split(":")[1].trim();
  
      Student f = new Student(firstName, lastName, grade, cohort);
      students[numStudents] = f;
      numStudents++;
    }
  }
  
  catch(FileNotFoundException ex){
    System.out.println("FILE NOT FOUND");
  }
  
  }



  private static void loadAllQuestions(String fileName) {
    questions = new Question[MAX_QUESTIONS];

    try{

      Scanner scanner = new Scanner(new File(fileName)); 
     
      while(scanner.hasNextLine()){
        String question = scanner.nextLine().split(":")[1].trim();
        int answer = Integer.parseInt(scanner.nextLine().split(":")[1].trim());
        int mark = Integer.parseInt(scanner.nextLine().split(":")[1].trim());
  
        Question f = new Question(question, answer, mark);
        questions[numQuestions] = f;
        numQuestions++;
      }
    }
    
    catch(FileNotFoundException ex){
      System.out.println("FILE NOT FOUND");
    }
  }




}


/**
 * Create a menu with the following functionality. 
 * 1. Create new class --- DONE DONE
 * 2. Create new student --- DONE DONE 
 * 3. Assign a student to a class --- DONE 
 * 4. Create a new question to add to the question bank --- DONE 
 * 5. Create a new assignment and assign to a class --- DONE 
 * 5a. Choose questions to add to the Assessment --- DONE 
 * 6. Allow a student to take a test from a specific class --- DONE
 * 7. Display a student's average 
 * 8. Display a student's results for a specific course/class 
 * 9. Display the average for all of the students in a class 
 * 10. Display the average for a specific course 
 * 11. Display all the students by grade --- DONE DONE
 * 12. Display all the students by cohort --- DONE DONE
 */










/**
         



private static void allowStudent (){

  System.out.println();
  System.out.println("Allow Student to Take Test from Class");
  System.out.println();
	System.out.println("______________________________");
	System.out.println();
  System.out.println("Course Code:");

  Scanner in = new Scanner(System.in);
  
  String course;

  for (int i = 1; i < numClasses; i++) {
    
    System.out.println(i+". " + classes[i-1].getCourseName());

  }

  int n = Integer.parseInt(in.nextLine());

  Class c = classes[n-1];

  String name = (in.nextLine());
  String dueDate = (in.nextLine());

  Assessment.assessment(name, dueDate, course);

}


private static void averageByStudent() {
  
  System.out.println();
  System.out.println("Display Student Average");
  System.out.println();
	System.out.println("______________________________");
	System.out.println();
  System.out.println("Student Name:");

  Scanner scanner = new Scanner(System.in);
  String studentName = scanner.nextLine();

  for () { // Search through to find student

    if (isMarked == true) {

      int[] tempGrades;

      for () {



      }

    }

  }
  
}

private static void studentAverageByClass(String courseCode) {
  
  System.out.println();
  System.out.println("Display Student Average by Course");
  System.out.println();
	System.out.println("______________________________");
	System.out.println();
  System.out.println("Student:");

  Scanner scanner = new Scanner(System.in);
  String studentName = scanner.nextLine();

  System.out.println();
  System.out.println("Student:");

  String class = scanner.nextLine();

  for () { // Search through to find course

  }
  
}

private static void averageByClass(String courseCode) {
  
  System.out.println();
  System.out.println("Display Class Average");
  System.out.println();
	System.out.println("______________________________");
	System.out.println();
  System.out.println("Course Code:");

  Scanner scanner = new Scanner(System.in);
  String studentName = scanner.nextLine();

  for () { // Search through to find course

  }
  
}
*/

 