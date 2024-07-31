import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] totalRanking = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                totalRanking[j][0] = Integer.parseInt(st.nextToken());
                totalRanking[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(totalRanking, Comparator.comparing((int[] o) -> o[0]));

            int passCount = 1;  // 서류 1순위
            int interviewRanking = totalRanking[0][1];
            for (int k = 1; k < totalRanking.length; k++) {
                if (totalRanking[k][1] < interviewRanking) {   // 합격
                    passCount++;
                    interviewRanking = totalRanking[k][1];
                }
            }
            sb.append(passCount).append("\n");
        }
        System.out.println(sb);
    }
}