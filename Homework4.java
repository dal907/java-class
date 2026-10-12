package homework;

import java.util.Scanner;

// 재귀호출 최대공약수
class RecursiveGCD {
    int gcd(int m, int n) {
        // n이 0이면 m이 최대공약수
        if (n == 0) {
            return m;
        }
        // m, n 중 작은 수와 큰 수를 구분
        int small, big;
        if (m < n) {
            small = m;
            big = n;
        }
        else {
            small = n;
            big = m;
        }

        // 작은 수, (큰 수 % 작은 수)로 다시 호출
        return gcd(small, big % small);
    }
}

// 반복문 최대공약수
class LoopGCD {
    int gcd(int m, int n) {
        while (n != 0) {
            int small, big;
            if (m < n) {
                small = m;
                big = n;
            }
            else {
                small = n;
                big = m;
            }

            m = small;
            n = big % small;
        }
        return m;
    }
}

public class Homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("두 수를 입력하세요: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        RecursiveGCD r = new RecursiveGCD();
        LoopGCD l = new LoopGCD();

        System.out.printf("두 수의 최대공약수는 %d입니다. (재귀호출)\n", r.gcd(num1, num2));
        System.out.printf("두 수의 최대공약수는 %d입니다. (반복문)\n", l.gcd(num1, num2));

        sc.close();
    }
}