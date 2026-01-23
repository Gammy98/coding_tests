package baekjoon.stack.p2504;

import java.util.*;
import java.io.*;

public class Main {
    static long ans = 0;
    static int tmp = 1;
    static Deque<Character> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                }
                if (input.charAt(i - 1) == '(') {
                    ans += tmp;
                }
                stack.pop();
                tmp /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                }

                if (input.charAt(i - 1) == '[') {
                    ans += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }
        if (stack.isEmpty()) {
            System.out.print(ans);
        }else{
            System.out.print(0);
        }
    }
}

//push할때 가중치를 계산해두는것이 point (너무 pop할때만 매몰되어잇었음..)
//사람처럼 괄호를 계산하려고 만들지 말고 그냥 분배법칙으로 풀어쓴걸 계산학세 하는게 편리하다(특히 중첩되는경우)