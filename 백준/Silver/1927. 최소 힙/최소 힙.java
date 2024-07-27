import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 연산의 개수 n
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        // 정수 x 는 값을 추가한다
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x > 0) {
                pQ.add(x);
            } else if (x == 0) {
                // 정수 x 가 0 이라면 가장 작은 값을 출력하고 큐에서 제거한다
                // 큐가 비어 있는데 가장 작은 값을 출력하라고 한 경우에는 0을 출력한다
                System.out.println(pQ.isEmpty() ? 0 : pQ.poll());
            }
        }
    }
}
