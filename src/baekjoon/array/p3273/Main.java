package baekjoon.array.p3273;

import java.io.*;
import java.util.*;

public class Main {
    static int n,x;
    static int[] arr;
    static boolean[] number = new boolean[2000001];
    // 각 자연수의 존재 여부를 저장하는 배열, 아래에서 x-i가 1000000보다 큰 경우를 예외처리하기 싫어서 그냥 배열을 최대 200만으로 잡음

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i : arr) {
            if (x - i > 0 &&  number[x - i]) { //조건식은 좌측부터 확인한다 !! 이런경우 x-i가 음수가 되면 안되므로 순서중요!
                ans++;
            }
            number[i] = true; //이 선언을 조건문 뒤에 둬야 i + i = x와 같은경우 예외 방지가능
        }
        System.out.print(ans);
    }
}
