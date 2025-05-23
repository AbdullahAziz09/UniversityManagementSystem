public class Course {
    String code;
    String title;
    int maxStudents;
    int enrolled;

    public Course(String code, String title, int maxStudents, int enrolled){
        this.code = code;
        this.title = title;
        this.maxStudents = maxStudents;
        this.enrolled = 0;
    }

    public void enrollStudent(){
        if(enrolled<maxStudents){
            enrolled++;
        }
    }

    @Override
    public String toString(){
        return "Course Code: "+code+"Tilte: "+title+"Enrolled: "+enrolled;
    }
}
