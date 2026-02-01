package baekjoon.stack.p6198__;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Deque<Integer> stack = new ArrayDeque<>();
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            ans += stack.size();
            stack.push(height);
        }
        System.out.println(ans);
    }
}
