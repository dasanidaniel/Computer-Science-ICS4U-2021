package gradebook2;

import java.util.Scanner;

public class Driver {

    private static final String YES = "Yes";
    private static final String YES2 = "yes";
    private static final String YES3 = "y";

   

    public static void main(String[] args) {

        boolean ends = false;
        Scanner options = new Scanner (System.in);
        Scanner in = new Scanner (System.in);
        

        while (!ends) {

            System.out.println();
            System.out.println("LEDSBY - School Software");
            System.out.println();
            System.out.println("1. Create Student");
            System.out.println("2. Create Course");
            System.out.println("3. Display Students");
            System.out.println("4. Display Courses");
            System.out.println("5. Add Assessment");
            System.out.println("6. Iterate Averages");
            System.out.println("7. Course Average");

            System.out.println();

            int option = Integer.parseInt(options.nextLine());
            
            System.out.println();
            System.out.println("______________________________");
            System.out.println();


            if (option == 1)
                School.newStudent(in);

            else if (option == 2)
                School.newCourse(in);
                
            else if (option == 3)
                School.displayStudents(in);

            else if (option == 4)
                School.displayCourses(in);

            else if (option == 5)
                School.addAssessment(in);

            else if (option == 6)
                Student.iterateAverage();

            else if (option == 7)
                School.getAverageByCourse(in);

                System.out.println();
                System.out.println("If you would like to use the menu again please type 'Yes', and if not please type 'No'");

                String end = (in.nextLine());

                if (end.equals(YES) || end.equals(YES2) || end.equals(YES3)){
                    ends = false;
                    System.out.println("");
                    System.out.println("____________________________");
                }

                else{
                    ends = true;
                }

            }

            in.close();
            options.close();

    }


}