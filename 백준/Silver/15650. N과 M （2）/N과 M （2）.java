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

        // 자연수 N, M
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = i+1;
        }

        visited = new boolean[n];
        result = new int[m];

        backTracking(0, 0);
    }

    public static void backTracking(int depth, int start) {
        if(depth == m) {    // {depth:0, m=2 / depth:1, m=2} / depth:2, m=2
            for (int j = 0; j < m; j++) {   // m =2
                System.out.print(result[j] + " ");  // - / 1 / 2 / 3
            }
            System.out.println();
        }else {
            for (int k = start; k < n; k++) {
                // 선택한 숫자보다 큰 숫자들 중에서 방문하지 않은 숫자를 선택
                if(!visited[k]) {   // {k:0 ,[false*,false,false,false] / k:1 ,[false,false*,false,false]} / {k:2 ,[true,false,false*,false]} / {k:3 ,[true,false,false,false*]}
                    // 선택한 숫자를 방문 표시
                    visited[k] = true;  // {[true*,false,false,false] / [true,true*,false,false]} / [true,false,false*,false] / [true,false,false,true*]
                    // 출력 배열에 선택한 숫자를 넣어줌
                    result[depth] = arrN[k];    // {result[1*,0,0,0] / result[1,2*,0,0]} / {result[1,3*,0,0]} / {result[1,4,0,0]}

                    backTracking(depth + 1, k + 1);
                    // 다음 숫자를 선택하고 선택했던 숫자를 false로 넣어줌
                    visited[k] = false; // {[false*,false,false,false] / [false,false*,false,false]} / [true,false,false*,false] / [true,false,false,true*]
                }
            }
        }
    }
}
