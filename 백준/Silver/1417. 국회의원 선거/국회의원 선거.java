import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 후보수 n
        int n = Integer.parseInt(br.readLine());

        // 1번 투표수 m 저장
        int m = Integer.parseInt(br.readLine());

        // 후보별 투표수를 PriorityQueue 에 넣는다. 우선순위가 높은 숫자가 먼저 나옴
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n-1; i++) {
            pQ.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        // m 과 비교하여 다른 후보의 투표수가 작을 때까지 표를 가져온다
        if(pQ.size() > 0) {
            while(m <= pQ.peek()) {
                int temp = pQ.peek();
                temp--;
                m++;
                pQ.poll();
                pQ.add(temp);
                count++;
            }
        }

        // 표를 가져 온 횟수를 출력한다
        System.out.println(count);
    }
}