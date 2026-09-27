package homework;
import java.util.Scanner;

// 학생 1명 정보를 담는 클래스
class Student {
    int id;        // 학번
    String name;   // 이름
    String major;  // 전공
    long phone;    // 전화번호 (맨 앞 0이 삭제, 숫자로 저장)

    // 학번
    int getId() {
        return id;
    }
    void setId(int id) {
        this.id = id;
    }
    // 이름
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    // 전공
    String getMajor() {
        return major;
    }
    void setMajor(String major) {
        this.major = major;
    }
    // 전화번호
    long getPhone() {
        return phone;
    }
    void setPhone(long phone) {
        this.phone = phone;
    }

    // 전화번호 문자열로 만듦
    String getFormattedPhone() {
        String p = "0" + Long.toString(phone); // 앞자리 0 복구
        return p.substring(0, 3) + "-" + p.substring(3, 7) + "-" + p.substring(7);
    }
}

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[3];

        //학생 3명 정보를 입력 (객체 생성)
        for (int i = 0; i < students.length; i++) {
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");
            // sc.next()로 띄어쓰기 단위 문자열을 하나씩 읽음
            students[i] = new Student();
            students[i].setId(Integer.parseInt(sc.next()));
            students[i].setName(sc.next());
            students[i].setMajor(sc.next());
            students[i].setPhone(Long.parseLong(sc.next()));
        }

        // 학생 정보 출력
        System.out.println("\n입력된 학생들의 정보는 다음과 같습니다.");
        for (int i = 0; i < students.length; i++) {
            System.out.println((i + 1) + "번째 학생: " + students[i].getId() + " " + students[i].getName() + " "
                    + students[i].getMajor() + " " + students[i].getFormattedPhone());
        }
    }
}
