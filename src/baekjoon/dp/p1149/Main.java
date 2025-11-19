package baekjoon.dp.p1149;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentR = Integer.parseInt(st.nextToken());
            int currentG = Integer.parseInt(st.nextToken());
            int currentB = Integer.parseInt(st.nextToken());

            int prevR = cost[0];
            int prevG = cost[1];
            int prevB = cost[2];

            cost[0] = currentR + Math.min(prevG, prevB);
            cost[1] = currentG + Math.min(prevR, prevB);
            cost[2] = currentB + Math.min(prevR, prevG);

        }
        int minCost = Math.min(cost[0], Math.min(cost[1], cost[2]));
        System.out.println(minCost);
    }
}