import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 두 수를 입력받으면 공백 기준으로 String에 저장한다
        String[] strArr = br.readLine().split(" ");

        // String 배열의 값을 각 String에 저징힌다
        String strOne = strArr[0];
        String strTwo = strArr[1];
        String revOne = "";
        String revTwo = "";


        // 각 String을 역순으로 저징힌다
        for(int i = strOne.length()-1; i >= 0; i--) {
            revOne += Character.toString(strOne.charAt(i));
        }
        for(int j = strTwo.length()-1; j >= 0; j--) {
            revTwo += Character.toString(strTwo.charAt(j));
        }

        // 두 수를 비교하여 큰수를 출력한다
        if(Integer.parseInt(revOne) > Integer.parseInt(revTwo)) {
            System.out.println(Integer.parseInt(revOne));
        }else {
            System.out.println(Integer.parseInt(revTwo));
        }
    }
}
