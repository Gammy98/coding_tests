package baekjoon.stack.p4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }

            Deque<Character> stack = new ArrayDeque<>();
            boolean isBalanced = true;

            for (char c : input.toCharArray()) {
                boolean flag = true;
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (isBalanced && stack.isEmpty()) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
