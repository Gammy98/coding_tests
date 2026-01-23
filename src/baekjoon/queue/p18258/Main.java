package baekjoon.queue.p18258;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }

    //채점방식때문에 한번에 몰아서 줘도 괜찮다!!! 명령어 입력할때마다 실시간 홗인이 아니라 프로그램 종료휴 전체 출력물을 비교
}



/* 시간초과 ,,
package baekjoon.queue.p18258;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Deque<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(queue.poll());
                }
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            } else if (command.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(queue.peek());
                }
            } else if (command.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(queue.peekLast());
                }
            }
        }

    }
}
 */