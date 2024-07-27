import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 t
        int t = Integer.parseInt(br.readLine());
        // 의상 종류 별로 의상의 개수를 담는 hashmap
        HashMap<String, Integer> costume = new HashMap<>();

        for (int i = 0; i < t; i++) {

            // 해빈이가 가진 의상의 수 n
            int n = Integer.parseInt(br.readLine());

            // 해빈이가 가진 의상 종류별로 의상 이름을 카운트하여 Hashmap 에 넣는다
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                // 입력 받아야 하므로 각 token 으로 저장해주기
                String clothes = st.nextToken();
                String type = st.nextToken();

                costume.put(type, costume.getOrDefault(type, 0) + 1);
            }

            int count = 1;  // 의상 개수를 곱하기 위해 1로 초기화
            for (Integer num : costume.values()) {
                count *= (num + 1);
            }
            sb.append(count-1).append("\n");
            costume.clear();
        }
        System.out.print(sb);
    }
}