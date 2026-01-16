package baekjoon.stack.p10828;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] st_arr = new int[1000005];
    static int pos = 0;

    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arrays.fill(st_arr, -1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                st_arr[pos] = num;
                pos ++;
            }
            else if (command.equals("pop")) {
                if (pos == 0) {
                    System.out.println(-1);
                }
                else{
                    System.out.println(st_arr[pos - 1]);
                    st_arr[pos-1] = -1;
                    pos --;
                }
            }
            else if (command.equals("size")) {
                System.out.println(pos);
            }
            else if (command.equals("empty")) {
                int ans = (pos == 0)? 1 : 0;
                System.out.println(ans);
            }
            else if (command.equals("top")) {
                if (pos == 0) {
                    System.out.println(-1);
                }
                else{
                    System.out.println(st_arr[pos - 1]);
                }
            }
        }
    }
}
