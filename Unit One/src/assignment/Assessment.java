package assignment;
import java.util.Date;

public class Assessment {
  private static final int MAX_QUESTIONS = 100;

  private Question[] questions;
  private static String assesmentName;
  private Date dueDate;
  private int numQuestions;

  public Assessment(String name, Date date) {

    this.assesmentName = name;
    this.dueDate = date;

    questions = new Question[MAX_QUESTIONS];

  }

  public void addQuestion(Question question) {

    this.questions[numQuestions] = question;
    numQuestions++;

  }

  public static String getAssesmentName() {
    return assesmentName;
  }

  public Date getDueDate(){
    return dueDate;
  }

}

