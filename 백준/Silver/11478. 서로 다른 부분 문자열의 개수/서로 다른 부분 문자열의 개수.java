import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 s
        String s = br.readLine();
        // 부분 문자열의 자리수
        int part = 0;
        // 부분 문자열의 개수
        int count = 0;
        // 부분 문자열을 담을 해쉬셋 - 부분 문자열에서 중복은 제외한다
        HashSet<String> subStringSet = new HashSet<>();

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < s.length() - part; j++) {
                subStringSet.add(s.substring(j, j+part+1));
            }
            part++;
        }
        System.out.println(subStringSet.size());
    }
}