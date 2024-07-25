import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스택의 명령의 수 저장
        int n = Integer.parseInt(br.readLine());

        // 스택을 생성한다
        Stack<Integer> stack = new Stack<>();

        // 명령이 주어질 때마다 수행한 결과를 출력한다
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();

             if(commend.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }else if(commend.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(stack.peek());
                }
            }else if(commend.equals("size")) {
                System.out.println(stack.size());
            }else if(commend.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }else if(commend.equals("pop")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(stack.pop());
                }
            }
        }
    }
}
