package gradebook2;

public class Assessment {
    private String assesmentName;
    private String relatedCourse;
    private int mark;

    public Assessment(String assesmentName, String relatedCourse, int mark) {
        this.assesmentName = assesmentName;
        this.relatedCourse = relatedCourse;
        this.mark = mark;
    }

    public String getaName(){
        return assesmentName;
    }

    public String getcourseCode(){
        return relatedCourse;
    }

    public int getMark(){
        return mark;
    }
    
}

