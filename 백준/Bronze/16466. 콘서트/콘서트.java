import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1차 티켓팅에서 팔린 티켓들의 수
        int n = Integer.parseInt(br.readLine());
        // 1차 티켓팅에서 팔린 티켓 번호
        int[] tickets = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            tickets[i] = Integer.parseInt(st.nextToken());
        }
        // 티켓들을 정렬한다
        Arrays.sort(tickets);
        int count = 0;
        // 티켓 0번째 부터 같지 않을 때까지 비교한다
        for(int i = 0; i < n; i++) {
            if (tickets[i] != i + 1) {
                System.out.println(i + 1);
                count++ ;
                break;
            }
        }
        // count 가 0이면 1번을 출력한다
        if (count == 0) {
            System.out.println(n + 1);
        }
    }
}
