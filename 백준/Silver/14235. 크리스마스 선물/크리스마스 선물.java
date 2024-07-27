import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 산타가 아이들과 거점지를 방문한 횟수 n
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());

        // a 의 숫자의 나열로 들어올 때 첫번째 숫자는 거점지에서 충전한 선물 개수, 다음의 숫자는 선물의 가치
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int visit = Integer.parseInt(st.nextToken());

            // a 의 숫자가 0 일 경우는 아이들에게 가장 가치가 큰 선물을 준다
            if (visit == 0) {
                sb.append(gift.isEmpty() ? "-1" : gift.poll()).append("\n");
            } else if (visit > 0) {
                // a 의 숫자가 나열하여 들어올 경우 두번째 숫자부터 gift 에 저장한다
                for (int j = 0; j < visit; j++) {
                    gift.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb);
    }
}
