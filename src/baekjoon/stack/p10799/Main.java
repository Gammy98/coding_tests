package baekjoon.stack.p10799;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Deque<Character> stack = new ArrayDeque<>();
        String input = sc.next();
        int ans = 0;
        boolean flag = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push('(');
                flag = true;
            } else if (c == ')' && flag == true) {
                stack.pop();
                ans += stack.size();
                flag = false;
            } else if (c == ')' && flag == false) {
                stack.pop();
                ans++;
            }
        }
        System.out.println(ans);
    }
}



/*
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력 속도 개선
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int ans = 0;
        int openParentheses = 0; // 스택 대신 개수를 카운트할 변수

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                openParentheses++;
            } else {
                // ')' 인 경우
                openParentheses--; // 일단 짝을 맞추기 위해 감소

                // 직전 문자가 '(' 였다면 레이저임
                if (input.charAt(i - 1) == '(') {
                    ans += openParentheses;
                } else {
                    // 직전 문자가 ')' 였다면 막대기의 끝임
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
 */
