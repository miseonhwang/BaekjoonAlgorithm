import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        // 단어 짧은 길이 정렬, 단어 사전순 정렬
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return s1.length() - s2.length();
            }
        });

        // 중복 제거
        sb.append(words[0]).append("\n");
        for (int j = 1; j < n; j++) {
            if(!words[j].equals(words[j-1])) {
                sb.append(words[j]).append("\n");
            }
        }
        System.out.println(sb);
    }
}