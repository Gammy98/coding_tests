package baekjoon.graphsearch.p1697;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        }
        else{
            Arrays.fill(time, -1);
            bfs();
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] next = {current - 1, current + 1, current * 2};
            for (int i : next) {

                if (i == K) {
                    System.out.println(time[current] + 1);
                    return;
                }

                if (i>=0 && i<100001 && time[i] == -1){
                    time[i] = time[current]+ 1;
                    queue.add(i);
                }
            }
        }
    }
}