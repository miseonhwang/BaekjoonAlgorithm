import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스의 갯수를 int 에 저장한다
        int test = Integer.parseInt(br.readLine());

        // 테스트 케이스만큼 실행한다
        for(int t = 0; t < test; t++) {
            // 반복 횟수 R과 문자열 S를 입력받아 String 배열에 저장한다
            String[] input = br.readLine().split(" ");

            // R은 int 로 저장하고 S는 String 에 저장한다
            int repeat = Integer.parseInt(input[0]);
            String str = input[1];

            // S의 문자열를 한 문자씩 R만큼 반복하여 출력한다
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < repeat; j++) {
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }
}