package assignment;

public class Question {
  
  private String question;
  private int answer;
  private int marks;

  public Question(String question, int answer, int marks) {
    this.question = question;
    this.answer = answer;
    this.marks = marks;
	}

  public String getQuestion() {
    return question;
  }
  
  public int getAnswer() {
    return answer;
  }
  
  
  public int getMarks() {
    return marks;
  }

}
