package gradebook2;

public class Student {
    private String firstName;
    private String lastName;
    private int studentNumber;
    private static Assessment[] assessments;
    private static int numAssessments;

public Student(String firstName, String lastName, int studentNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.studentNumber = studentNumber;
    this.assessments = new Assessment[100];
}



public String getfName() {
    return firstName;
}



public String getlName() {
    return lastName;
}



public int getNumber() {
    return studentNumber;
}



public static void addAssessment(Assessment x) {

    assessments[numAssessments] = x;
    numAssessments++;

}


public static void iterateAverage() {

    int allMarks = 0;
    int k = 0;

    for (int i = 0; i<assessments.length-1;i++){

        if (assessments[i]!=null){

        allMarks += assessments[i].getMark();
        k++;

        }

    }

    allMarks = allMarks/k;
    System.out.println();
    System.out.println(allMarks);
    System.out.println();

}


public static void getCourseAverage(String courseCode) {

    int allMarks = 0;
    int k = 0;

    for (int i = 0; i<assessments.length-1;i++){

        if (assessments[i]!=null){

            if (assessments[i].getcourseCode().equals(courseCode)){

            allMarks += assessments[i].getMark();
            k++;
            
            }

        }

    }

    allMarks = allMarks/k;
    System.out.println();
    System.out.println(allMarks);
    System.out.println();
     
}


}
