package assignment;

import java.util.Date;
import java.util.Scanner;

public class Assessment {
  private static final int MAX_QUESTIONS = 100;

  private Question[] questions;
  private Assessment[] assessments;
  private String assesmentName;
  private String dueDate;
  private int numQuestions;
  private int numAssessments;

  public Assessment(String name, String newDueDate) {

    this.assesmentName = name;
    this.dueDate = newDueDate;

    questions = new Question[MAX_QUESTIONS];

  }

  public void addQuestion(Question question) {

    this.questions[numQuestions] = question;
    numQuestions++;

  }

  public String getAssesmentName() {
    return assesmentName;
  }

  public String getDueDate(){
    return dueDate;
  }


  public void addAssessment(Student students){

    Scanner in = new Scanner(System.in);
    String assesmentName = in.nextLine();
    String dueDate = in.nextLine();

    Assessment f = new Assessment(assesmentName, dueDate);
    assessments[numAssessments] = f;
    numAssessments++;
  }



}

