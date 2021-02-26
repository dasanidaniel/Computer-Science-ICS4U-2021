package assignment;

public class Question {
  private String question;
  private String answer;
  private int marks;

  public Question(String question, String answer, int marks) {
    this.question = question;
    this.answer = answer;
    this.marks = marks;
	}

  public String getQuestion() {
    return question;
  }
  
  public String getAnswer() {
    return answer;
  }
  
  
  
  public int getMarks() {
    return marks;
  }

}
