import java.io.*;

public class Main {
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;

        while(true) {
            int sum = 0;
            // 양의 정수의 길이가 1일 경우 종료한다
            if(str.length() == 1) {
                break;
            }
            // 양의 정수를 string 에서 한자리씩 더해준다
            for (int i = 0; i < str.length(); i++) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            // 더한 값을 str 에 넣어준다
            str = String.valueOf(sum);
            // 몇번 더하였는지 카운트한다
            count++;
        }

        System.out.println(count);
        // 한자리수인 str가 3의 배수이면 Yes를 출력한다
        if(Integer.parseInt(str) % 3 == 0) {
            System.out.println("YES");
        }else {
            // 한자리수인 str가 3의 배수가 아니면 No를 출력한다
            System.out.println("NO");
        }
    }
}