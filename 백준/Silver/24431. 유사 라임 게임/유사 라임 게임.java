import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            HashMap<String, Integer> words = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String wordSuffix = st.nextToken().substring(l - f);
                words.put(wordSuffix, words.getOrDefault(wordSuffix, 0) + 1);
            }

            int rhyme = 0;
            for (int val : words.values()) {
                rhyme += val / 2;
            }

            sb.append(rhyme).append("\n");
        }
        System.out.println(sb);
    }
}
