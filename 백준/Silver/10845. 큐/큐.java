import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 큐의 명령의 수 n을 저장한다
        int n = Integer.parseInt(br.readLine());

        // 큐를 생성한다
        Queue<Integer> queue = new LinkedList<>();
        // 명령이 주어질 때마다 수행한 결과를 출력한다
        // push 1 push 2 front back size empty pop pop pop size empty pop puth 3 empty front
        //                 1    2    2     0    1   2  -1   0     1   -1           0     3

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();

            if(commend.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            }else if(commend.equals("front")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(queue.peek());
                }
            }else if(commend.equals("back")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(((LinkedList<Integer>)queue).getLast());
                }
            }else if(commend.equals("size")) {
                System.out.println(queue.size());
            }else if(commend.equals("empty")){
                if(queue.isEmpty()) {
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }else if(commend.equals("pop")) {
                if(queue.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(queue.poll());
                }
            }
        }
    }
}