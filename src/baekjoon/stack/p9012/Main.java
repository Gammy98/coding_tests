package baekjoon.stack.p9012;

import java.util.*;
import java.io.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '(') {
                    stack.push('(');
                }
                else{
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        else{
                            stack.push(')');
                            break;
                        }
                    }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
