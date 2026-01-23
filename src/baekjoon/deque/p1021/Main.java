package baekjoon.deque.p1021;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int ans = 0;
    static int[] targets;
    static LinkedList<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for (int target : targets) {
            int index = queue.indexOf(target); // 이거땜에 ArrayDeque 말고 LinkedList
            int size = queue.size() / 2;

            if (index <= size) {
                for (int i = 0; i < index; i++) {
                    queue.addLast(queue.pollFirst()); //왼쪽 로테이션
                    ans ++;
                }
            }
            else{
                for (int i = 0; i < queue.size()-index; i++) {
                    queue.addFirst(queue.pollLast()); //오른쪽 로테이션
                    ans ++;
                }
            }
            queue.pollFirst();
        }
        System.out.println(ans);
    }
}
