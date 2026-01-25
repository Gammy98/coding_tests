package baekjoon.queue.p5430;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrInput = br.readLine();

            // 1. 입력 처리
            Deque<Integer> deque = new ArrayDeque<>();
            String s = arrInput.substring(1, arrInput.length() - 1);
            if (!s.isEmpty()) {
                String[] nums = s.split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean isForward = true;
            boolean isError = false;

            // 명령어 처리
            for (char cmd : p.toCharArray()) {
                if (cmd == 'R') {
                    isForward = !isForward; // 상태만 반전
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isForward) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            // 출력
            if (isError) {
                result.append("error\n");
            } else {
                result.append("[");
                while (!deque.isEmpty()) {
                    // 현재 방향에 따라 앞에서 뺄지 뒤에서 뺄지 결정
                    result.append(isForward ? deque.pollFirst() : deque.pollLast());
                    if (!deque.isEmpty()) result.append(",");
                }
                result.append("]\n");
            }
        }
        System.out.print(result);
    }
}