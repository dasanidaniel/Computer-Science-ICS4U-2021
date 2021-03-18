package gradebook2;
import java.util.Scanner;

public class School {
    private static final int MAX_STUDENTS = 1000;
    private static final int MAX_CLASSES = 75;
    private static Student[] enrolledStudents = new Student[MAX_STUDENTS];
    private static int numStudents = 0;
    private static Course[] offeredCourses = new Course[MAX_CLASSES];
    private static int numCourses = 0;



    public static void newStudent(Scanner scanner) {

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
        System.out.println("Student Number:");

        int studentNumber = Integer.parseInt(scanner.nextLine()); 
    
        Student f = new Student (firstName, lastName, studentNumber);
        enrolledStudents[numStudents] = f;
        numStudents++;

    }

    public static void newCourse(Scanner scanner) {

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
        
        Course f = new Course (courseName, courseCode);
        offeredCourses[numCourses] = f;
        numCourses++;

    }

    public static void displayStudents(Scanner scanner) {

        for (Student x : enrolledStudents) {
            if (x != null) {
            
            System.out.println();
            System.out.println(x.getfName());
            System.out.println(x.getlName());
            System.out.println(x.getNumber());
      
      
          }
        }
      
        System.out.println("______________________________");
        System.out.println();

    }

    public static void displayCourses(Scanner scanner) {

        for (Course x : offeredCourses) {
            if (x != null) {
            
            System.out.println();
            System.out.println(x.getcourseCode());
            System.out.println(x.getcourseName());      
      
          }
        }
      
        System.out.println("______________________________");
        System.out.println();

    }

    public static void addAssessment(Scanner scanner) {

        System.out.println();
        System.out.println("Add Assessment");
        System.out.println();
        System.out.println("______________________________");
        System.out.println();
       
        System.out.println();
        System.out.println("Student Number:");
        
        int studentNumber = Integer.parseInt(scanner.nextLine());
        System.out.println();

        for (int x = 0; x < enrolledStudents.length-1; x++) {

            if (enrolledStudents[x] !=null){

                if (enrolledStudents[x].getNumber() == studentNumber) {

                    System.out.println();
                    System.out.println("Please enter the name of the assessment: ");
                    
                    String assessmentName = scanner.nextLine();

                    System.out.println();
                    System.out.println("Please enter the mark: ");
                    System.out.println();

                    int aMark = Integer.parseInt(scanner.nextLine());

                    System.out.println();
                    System.out.println("Please enter the course code: ");
                    System.out.println();

                    String courseCode = scanner.nextLine();

                    Assessment a = new Assessment(assessmentName, courseCode, aMark);
                    Student.addAssessment(a);
                    
                }
            }
        }

    }

        /**
        for (int i = 0; i < enrolledStudents.length-1; i++) {

            if (enrolledStudents[i].getNumber().equals(stuNumber)) {

            System.out.println();
            System.out.println("Course Code:");
            
            String courseCode = scanner.nextLine();

            for (int j = 0; j < numCourses; j++) {

                if (courseCode.equals(offeredCourses[j].getcourseCode())) {
                    
                    System.out.println();
                    System.out.println("Assessment Mark:");
                    
                    int assessmentMark = Integer.parseInt(scanner.nextLine()); 

                    System.out.println();
                    System.out.println("Assessment Name:");
                    
                    String assessmentName = scanner.nextLine();

                    Assessment x = new Assessment(assessmentName, courseCode, assessmentMark);
                    Student.addAssessment(x);

                }
            
            }
            
            }   

        }
        
    }
*/

    public static void getAverageByCourse(Scanner scanner) {

        System.out.println();
        System.out.println("Average of Course");
        System.out.println();
        System.out.println("______________________________");
        System.out.println();

        System.out.println();
        System.out.println("Course code:");

                
        String courseCode = scanner.nextLine();

        Student.getCourseAverage(courseCode);

    
    }

}
