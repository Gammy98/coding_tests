package baekjoon.deque.p10866;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int MX = 10005;
    static int[] deque = new int[2 * MX + 1];
    static int head=MX, tail=MX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                push_front(num);
            } else if (command.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                push_back(num);
            }else if (command.equals("pop_front")) {
                pop_front();
            }else if (command.equals("pop_back")) {
                pop_back();
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

    static void push_front(int x) {
        deque[--head] = x;
    }
    static void push_back(int x) {
        deque[tail++] = x;
    }

    static void pop_front() {
        if (tail == head) {
            System.out.println(-1);
            return;
        }
        System.out.println(deque[head++]);
    }

    static void pop_back() {
        if (tail == head) {
            System.out.println(-1);
            return;
        }
        System.out.println(deque[--tail]);
    }

    static void size() {
        System.out.println(tail - head);
    }
    static void empty() {
        if (tail == head) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
    static void front() {
        if (tail == head) {
            System.out.println(-1);
            return;
        }
        System.out.println(deque[head]);
    }
    static void back() {
        if (tail == head) {
            System.out.println(-1);
            return;
        }
        System.out.println(deque[tail-1]);
    }
}
