package baekjoon.stack.p3986;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() % 2 != 0) {
                continue;
            }

            Deque<Character> stack = new ArrayDeque<>();
            for (char c : input.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else{
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}
