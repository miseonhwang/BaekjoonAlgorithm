import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arrN;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 자연수 N, M 을 입력받아 그 크기만큼 배열을 생성하여 1~N 의 값을 저장한다
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] += i+1;
        }

        // 방문 여부를 저장하는 배열
        visited = new boolean[n];
        result = new int[n];

        backTracking(0);
    }

    public static void backTracking(int depth)  {
        // 수열의 길이가 M에 도달하면 선택한 수열을 출력
        if(depth == m) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }else {
            // arrN 의 1부터 뒤의 수열을 나열
            for (int k = 0; k < n; k++) {
                // 선택한 숫자보다 큰 숫자들 중에서 방문하지 않은 숫자를 선택
                if(!visited[k]) {
                    // 선택한 숫자를 방문 표시
                    visited[k] = true;
                    // 배열에 선택한 숫자를 넣어줌
                    result[depth] = arrN[k];

                    backTracking(depth + 1);
                    // 다음 숫자를 선택하고 선택했던 숫자를 false로 넣어줌
                    visited[k] = false;
                }
            }
        }
    }
}
