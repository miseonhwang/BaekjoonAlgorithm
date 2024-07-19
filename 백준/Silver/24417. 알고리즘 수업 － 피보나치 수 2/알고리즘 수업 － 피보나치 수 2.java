import java.lang.*;
import java.io.*;

/*
 * 피보나치 수열을 주어진 재귀호출과 동적 프로그래밍 방식으로 구할 경우 실행 횟수를 출력한다
 */
public class Main {
    // 이전에 계산한 값을 저장해 놓을 배열을 선언한다
    static long[] memo;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력을 받아 두가지 알고리즘에 적용한다
        int n = Integer.parseInt(br.readLine());
        System.out.println(dynamicFibonacci(n) + " " + count  % 1_000_000_007);
    }

    public static long dynamicFibonacci(int n) {
        // 배열을 생성하여 배열 1번째, 2번째 값을 저장한다 (배열의 0번째는 1로 지정한다)
        int[] cci = new int[n + 1];
        cci[1] = 1;
        cci[2] = 1;
        // 배열의 3번째부터 n번째까지 -1, -2 위치의 값을 더하여 저장한다
        for(int i = 3; i <= n; i++) {
            cci[i] = (cci[i - 1] + cci[i - 2]) % 1_000_000_007;
            count++;
        }
        return cci[n];
    }
}