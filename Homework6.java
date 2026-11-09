package homework;

class Course {
    protected String code;   // 과목 코드
    protected String name;   // 과목 이름
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public String getCode() { return code; }
    public String getName() { return name; }
}

class OnlineCourse extends Course {
    public OnlineCourse(String code, String name) {
        super(code, name);   // 부모 클래스(Course)의 생성자 호출
    }
    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name + ", Type: Online";
    }
}

class OfflineCourse extends Course {
    public OfflineCourse(String code, String name) {
        super(code, name);
    }
    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name + ", Type: Offline";
    }
}

public class Homework6
{
    public static void main(String[] args) {
        OfflineCourse course1 = new OfflineCourse("HAEA9201", "Object Oriented Programming");
        OnlineCourse course2 = new OnlineCourse("HAFL0012", "C Programming 1");
        System.out.println (course1);
        System.out.println (course2);
    }
}