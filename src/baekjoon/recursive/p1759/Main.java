package baekjoon.recursive.p1759;

import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr;
    static char[] pw_arr;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        pw_arr = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        //메인로직
        Arrays.sort(arr);
        solve(0,0);

        //출력
        System.out.print(ans);
    }

    static void solve(int k, int idx) {
        if (k == L) {
            if (isValid()) {
                for (char c : pw_arr) {
                    ans.append(c);
                }
                ans.append("\n");
            }
            return;
        }
        for (int i =idx; i<C;i++) {
            pw_arr[k] = arr[i];
            solve(k + 1, i+1);
        }
    }

    static boolean isValid() {
        int vowel = 0;
        int consonent = 0;

        for (char c : pw_arr) {
            if (isVowel(c)){
                vowel++;
            }
            else{
                consonent++;
            }
        }

        return vowel >= 1 && consonent >= 2;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
