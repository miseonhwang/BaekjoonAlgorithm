import java.lang.*;
import java.io.*;

/*
 * 피보나치 수열을 주어진 재귀호출과 동적 프로그래밍 방식으로 구할 경우 실행 횟수를 출력한다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력을 받아 두가지 알고리즘에 적용한다
        int n = Integer.parseInt(br.readLine());
        // 재구호출 방식으로 출력한다
        System.out.println(recursionFibonacci(n));
        System.out.println(dynamicFibonacci(n));
        // 동적 프로그래밍 방식으로 출력한다

    }
    // 피보나치 수 재귀호출 의사 코드
    public static int recursionFibonacci(int n) {
        // 실행 횟수를 저장 할 변수를 선언한다
        int count = 0;
        // 입력받은 값이 2이하면 즉시 리턴한다
        // 2이상이면 재귀함수로 호출하여 계산한 값을 반환한다
        count++;
        if(n <= 2) {
            return count;
        }else {
            return recursionFibonacci(n - 1) + recursionFibonacci(n - 2);
        }
    }

    // 피보나치 수 동적 프로그래밍 의사 코드
    public static int dynamicFibonacci(int n) {
        // 실행 횟수를 저장 할 변수를 선언한다
        int count = 0;
        // 입력받은 값이 2이하면 즉시 리턴한다
        if(n <= 2) {
            return n;
        }
        // 배열을 생성하여 배열 1번째, 2번째 값을 저장한다 (배열의 0번째는 1로 지정한다)
        int[] cci = new int[n + 1];
        cci[1] = 1;
        cci[2] = 2;
        // 배열의 3번째부터 n번째까지 -1, -2 위치의 값을 더하여 저장한다
        for(int i = 3; i <= n; i++) {
            cci[i] = cci[i - 1] + cci[i - 2];
            count++;
        }
        return count;
    }
}
