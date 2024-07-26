import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 비밀번호 개수 n
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> password = new HashMap<>();

        // 비밀번호를 전부 입력받는다
        for (int i = 0; i < n; i++) {
            String inputPw = br.readLine();
            String[] reverse = inputPw.split("");
            String reversePw = "";

            for (int j = reverse.length -1; j >= 0; j--) {
                reversePw += reverse[j];
            }
            password.put(inputPw, reversePw);
        }

        // 비밀번호를 뒤집어 놓은 문자열을 다른 비밀번호 문자열과 비교하기
        String answer = "";
        for(String key : password.keySet()) {
            // value 에 key 와 같은 문자열이 있는지 확인하기
            if(password.containsValue(key)) {
                // 비밀번호 저장
                answer = key;
            }
        }

        // 비밀번호의 길이와 가운데 글자를 출력한다
        System.out.println(answer.length() + " " + answer.charAt(answer.length()/2));
    }
}