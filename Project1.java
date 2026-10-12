package homework;

import java.util.Scanner;

public class Project1 {
    final int MAX_HISTORY = 10;
    String[] history = new String[MAX_HISTORY];
    int count = 0;
    Scanner sc = new Scanner(System.in);

    // '/'로 시작하는지 확인
    boolean Slash(String str) {
        return str.charAt(0) == '/';
    }

    // /help 입력, 도움말 출력
    void printHelp() {
        System.out.println("Type a Java language expression, statement, or declaration.");
        System.out.println("Or type one of the following commands:");
        System.out.println("/list: list the source you have typed.");
        System.out.println("/exit: exit the jshell tool");
        System.out.println("/history: history of what you have typed.");
        System.out.println("/!: rerun last snippet.");
    }

    // /history 입력시 입력한 내용 출력
    void printHistory() {
        for (int i = 0; i < count; i++) {
            System.out.println(history[i]);
        }
    }

    // /list 입력, (숫자 : '/'로 시작 안하는 문장) 출력
    void printList() {
        int num = 1;
        for (int i = 0; i < count; i++) {
            if (!Slash(history[i])) {
                System.out.println(num + " : " + history[i]);
                num++;
            }
        }
    }

    // /! 입력시 실행
    void rerun() {
        for (int i = count - 1; i >= 0; i--) {
            if (!Slash(history[i])) {
                System.out.println("Re-running '" + history[i] + "'.");
                return;
            }
        }
    }

    // 입력한 내용을 배열에 저장
    void addHistory(String str) {
        history[count++] = str;
        if (count == MAX_HISTORY) {
            count = 0;
            System.out.println("The history buffer is cleared.");
        }
    }

    void run() {
        while (true) {
            System.out.print("jshell> ");
            String input = sc.nextLine().trim();

            if (input.length() == 0) {
                continue;
            }

            if (Slash(input)) {
                switch (input) {
                    case "/exit":
                        System.out.println("Goodbye.");
                        return;  // 종료
                    case "/help":
                        printHelp();
                        break;
                    case "/history":
                        printHistory();
                        break;
                    case "/list":
                        printList();
                        break;
                    case "/!":
                        rerun();
                        break;
                    default:  // 위에 없는 '/' 명령어
                        System.out.println("Invalid command: " + input);
                        System.out.println("Type /help for help.");
                        break;
                }
            }
            else {
                System.out.println("Running '" + input + "'.");
            }
            System.out.println();
            addHistory(input);
        }
    }

    public static void main(String[] args) {
        Project1 shell = new Project1();
        shell.run();
    }
}