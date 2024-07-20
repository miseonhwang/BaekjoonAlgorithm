import java.io.*;

/**
 * 입력값이 없을경우 배열에 빈 문자열을 저장하여 문자열의 길이가 1로 출력된다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문장을 입력받아 앞뒤 공백을 제거하여 String 에 저장한다
        String str = br.readLine().trim();
        // 문장을 공백을 기준으로 배열에 저장한다
        String[] strArr = str.split(" ");
        if(str.equals("")) {
            // 입력받은 문자열에 trim()함수를 취한 결과가 빈 문자열인 경우 0으로 출력한다
            System.out.println(0);
        }else {
            // String 배열 길이를 출력한다
            System.out.println(strArr.length);
        }
    }
}