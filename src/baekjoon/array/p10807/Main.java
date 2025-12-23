package baekjoon.array.p10807;
import java.io.*;
import java.util.*;

public class Main {
    static int N,V;
    static int[] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        V = Integer.parseInt(br.readLine());

        for (int i : arr) {
            if (i == V) {
                ans ++;
            }
        }
        System.out.println(ans);
    }
}
