package baekjoon.queue.p10845;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] queue = new int[10005];
    static int head=0, tail=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                push(num);
            } else if (command.equals("pop")) {
                pop();
            }else if (command.equals("size")) {
                size();
            }else if (command.equals("empty")) {
                empty();
            }else if (command.equals("front")) {
                front();
            }else if (command.equals("back")) {
                back();
            }
        }
    }
    static void push(int x) {
        queue[tail++] = x;
    }

    static void pop() {
        if (tail == head) {
            System.out.println(-1);
            return;
        }
        int res = queue[head++];
        System.out.println(res);
    }

    static void size() {
        System.out.println(tail-head);
    }
    static void empty() {
        if (tail == head) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    static void front() {
        if (tail == head) {
            System.out.println(-1);
            return;
        }
        System.out.println(queue[head]);

    }
    static void back() {
        if (tail == head) {
            System.out.println(-1);
            return;
        }
        System.out.println(queue[tail-1]);
    }
}
