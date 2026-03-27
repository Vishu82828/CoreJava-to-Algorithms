public class class01 {
    public static void main(String[] args) {
        Student s1 = new Student("Aniket", 25);
        Student s2 = new Student("Vishwajeet");
        Student.schoolName = "Oxford University";
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(Student.schoolName);
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
        System.out.println(s2.schoolName);
    }
}
class Student{
    private String name;
    private int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Student(String name){
        this.name= name;
        this.age = 18;
    }
    public static String schoolName;
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
}
