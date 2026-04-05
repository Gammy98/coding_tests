package baekjoon.graphsearch.p15686;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] city;
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static boolean[] isVisited;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    house.add(new Point(i, j));
                } else if (num == 2) {
                    chicken.add(new Point(i, j));
                }
                city[i][j] = num;
            }
        }
        isVisited = new boolean[chicken.size()];

        dfs(0, 0);
        System.out.print(minDist);
    }

    static void dfs(int start, int cnt) {
        if (cnt == M) {
            minDist = Math.min(minDist,calculate());
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            isVisited[i] = true;
            dfs(i + 1, cnt + 1);
            isVisited[i] = false;
        }
    }

    static int calculate() {
        int sum = 0;
        for (Point p : house) {
            int dist = Integer.MAX_VALUE;


            for (int i = 0; i < chicken.size(); i++) {
                if (isVisited[i]) {
                    Point c = chicken.get(i);
                    dist = Math.min(Math.abs(p.x - c.x) + Math.abs(p.y - c.y), dist);
                }
            }
            sum += dist;
        }
        return sum;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
