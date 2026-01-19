package baekjoon.stack.p2493;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] height = new int[500005];
    static int[] st_arr = new int[500005];
    static int cur = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            int current = Integer.parseInt(st.nextToken());
            height[i] = current;

            while (cur > 0) {
                if (height[top()] >= current) {
                    sb.append(top() + " ");
                    break;
                }
                pop();
            }

            if (cur == 0) {
                sb.append("0 ");
            }
            push(i);
        }
        System.out.println(sb);
    }

    static int top(){
        return st_arr[cur - 1];
    }

    static void push(int num) {
        st_arr[cur++] = num;
    }

    static void pop() {
        cur --;
    }


}





/*  O(n*2)를 쓰면 무조건 시간초과 (N이 500000이므로 2억5천이 된다)
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        temple = new int[N+1];
        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        for (int i = 1; i < N+1; i++) {
            temple[i] = sc.nextInt();
            for (int j=i-1; j >= 0; j--){
                if (temple[j] >= temple[i]) {
                    sb.append(j+" ");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("0 ");
            }
            flag = false;
        }
        System.out.print(sb);
}
 */