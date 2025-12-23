package baekjoon.array.p3273;

import java.io.*;
import java.util.*;

public class Main {
    static int n,x;
    static int[] arr;
    static boolean[] number = new boolean[2000001];
    // 각 자연수의 존재 여부를 저장하는 배열, 아래에서 x-i가 1000000보다 큰 경우를 예외처리하기 싫어서 그냥 배열을 최대 200만으로 잡음
    // 범위 조건은 항상중요!!

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



//x의 범위가 너무 커져서 배열생성이 바로힘든경우는 투포인터 사용 (sorting해야하므로 최소 O(nlogn)이다)
//아래와 같은 경우 메모리초과 걱정이 없고 실제 원소만 가지고 계산하므로 안정성 올라감
/*
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        // 1. 투 포인터를 쓰기 위해 반드시 정렬을 해야 합니다.
        Arrays.sort(arr);

        int ans = 0;
        int left = 0;
        int right = n - 1;

        // 2. 두 포인터가 만날 때까지 반복합니다.
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                ans++;
                left++;
                right--;
            } else if (sum < x) {
                // 합이 작으면 작은 쪽(left)을 키워줍니다.
                left++;
            } else {
                // 합이 크면 큰 쪽(right)을 줄여줍니다.
                right--;
            }
        }

        System.out.print(ans);
    }
}
 */
