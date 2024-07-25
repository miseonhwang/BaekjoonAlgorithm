import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 처음 입력되는 N은 막대기의 개수
        int n = Integer.parseInt(br.readLine());

        // 막대기를 입력받아 stack 에 저장
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        // stack 에서 가장 최근의 막대기 숫자보다 큰 값 찾기
        int count = 1;  // 가장 앞의 막대기는 보임
  
        int minHeight = stack.peek();
        for (int j : stack) {
            stack.pop();
            // stack 이 비어있을 경우 종료
            if (!stack.isEmpty()) {

                // 가장 앞의 막대기보다 다음 막대기가 크면 카운트
                if (stack.peek() > minHeight) {
                    minHeight = stack.peek();
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}