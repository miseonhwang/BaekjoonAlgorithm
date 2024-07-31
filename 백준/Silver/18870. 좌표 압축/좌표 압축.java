import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] original = new int[n];
        int[] sort = new int[n];
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            original[i] = node;
            sort[i] = node;
        }

        Arrays.sort(sort);

        int rank = 0;
        for (Integer key : sort) {
            if(!rankMap.containsKey(key)) {
                rankMap.put(key, rank);
                rank++;
            }
        }

        for (Integer sequence : original) {
            sb.append(rankMap.get(sequence)).append(" ");
        }

        System.out.println(sb);
    }
}