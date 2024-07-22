import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 정수 N을 입력받아 int변수에 저장한다
        int n = Integer.parseInt(br.readLine());
        // n만큼 int배열을 만들고 정수를 저장한다
        int[] arrN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 두번째 정수 M을 입력받아 int변수에 저장한다
        int m = Integer.parseInt(br.readLine());
        // m만큼 int배열을 만들고 정수를 저장한다
        int[] arrM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 이진탐색 방법을 사용하기 위해 시작 인덱스와 마지막 인덱스 값을 지정합니다

        boolean find = false;
        Arrays.sort(arrN);

        // arrM을 반복문에 돌려서 arrN의 정수와 한개씩 비교하여 arrRes에 값을 저장한다
        for (int i = 0; i < arrM.length; i++) {
            find = false;
            int low = 0;
            int high = arrN.length - 1;

            while(low <= high) {
                int mid = (low + high) / 2;
                if (arrM[i] == arrN[mid]) {
                    find = true;
                    System.out.print(1 + " ");
                    break;
                } else if (arrM[i] > arrN[mid]) {
                    low = mid + 1;
                } else if (arrM[i] < arrN[mid]) {
                    high = mid - 1;
                }
            }
            if(!find) System.out.print(0 + " ");
        }
    }
}
