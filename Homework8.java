package homework;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Homework8 {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<String, String>();
        users.put("myId", "myPass");
        users.put("myId2", "myPass2");
        users.put("myId3", "myPass3");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요.");
            System.out.print("id : ");
            String id = sc.nextLine().trim();   // 뒤에 입력된 공백 무시

            // 입력된 ID가 해시맵에 없으면 다시 입력
            if (!users.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                System.out.println();
                continue;
            }

            System.out.print("password : ");
            String password = sc.nextLine().trim();

            // 해시맵에서 ID에 해당하는 비밀번호를 꺼내 비교
            if (users.get(id).equals(password)) {
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }
            else {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                System.out.println();
            }
        }

        sc.close();
    }
}