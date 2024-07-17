import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        String answer = "";
        String[] date = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] date_per_month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month_stack = 0;

        // 입력한 월의 전월까지 일수를 더하기
        for(int i = 1; i < a; i++) {
            month_stack += date_per_month[i];
        }
        // 입력한 일수를 더하기
        month_stack += b;
        // 요일의 길이보다 작아질 때까지 빼기
        while(month_stack > date.length) {
            month_stack -= date.length;
        }

        answer = date[month_stack-1];
        System.out.println(answer);
    }
}
