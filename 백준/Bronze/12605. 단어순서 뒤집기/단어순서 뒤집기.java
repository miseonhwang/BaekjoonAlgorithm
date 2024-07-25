import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전체 케이스의 개수 n
        int n = Integer.parseInt(br.readLine());

        // n개의 단어리스트를 입력받음
        for (int i = 1; i <= n; i++) {
            // 단어리스트를 단어별로 stack 에 저장
            Deque<String> stack = new ArrayDeque<>();
            String[] sArr = br.readLine().split(" ");
            for (String s : sArr) {
                stack.push(s);
                stack.push(" ");
            }

            System.out.print("Case #" + i + ":");
            // 스택 출력
            for (String st : stack) {
                System.out.print(st);
            }
            System.out.println();
        }
    }
}