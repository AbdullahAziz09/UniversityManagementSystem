public class Faculty {
    int id;
    String name;

    public Faculty(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Faculty ID: "+id+"Faculty Name: "+name;
    }
}
