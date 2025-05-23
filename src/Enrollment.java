public class Enrollment {
    Student student;
    Course course;

    public Enrollment(Student student, Course course){
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString(){
        return student.name+" is Enrolled in "+course.title;
    }
}
