package baekjoon.bfs.p5014;

import java.util.*;
import java.io.*;

public class Main {

    static int F,S,G,U,D;
    static int[] floor;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        floor = new int[F + 1];
        Arrays.fill(floor,-1);

        int answer = bfs();

        if (answer == -1) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(answer);
        }
    }

    public static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        floor[S] = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (current == G) {
                return floor[current];
            }

            int afterup = current + U;
            int afterdown = current - D;

            if (afterup <= F && floor[afterup] == -1) {
                floor[afterup] = floor[current] + 1;
                queue.add(afterup);
            }

            if (afterdown >= 1 && floor[afterdown] == -1) {
                floor[afterdown] = floor[current] + 1;
                queue.add(afterdown);
            }

        }
        return -1;
    }
}
