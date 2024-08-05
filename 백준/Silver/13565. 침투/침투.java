import java.io.*;
import java.util.*;

public class Main {
    static int[][] gridFiber;
    static int m, n;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /**
         * 2차언 M X N 격자모양의 섬유물질이 위쪽에서 아래쪽으로 전류가 통하는지 확인
         *
         * 1. 입력
         * 격자 크기 M, N
         * M 줄의 0 또는 1 의 N 개의 값
         *
         * 2. 기능
         * 2-1. 초기화
         * 2-1-0. M x N 의 2차원 배열 생성
         * 2-2-1. 0,1 값을 배열에 초기화
         *
         * 2-2. 전류가 침투하며 visited 에 true 체크
         * 2-2-0. visited 배열 생성 (M x N)
         * 2-2-1. dx, dy 세팅
         * 2-2-2. dfs 로 상, 하, 좌, 우 확인
         *
         * 3. 출력
         * 3-1-0. visited 가장 아래줄에 true 가 있는지 확인
         * 3-1-1. true 가 있다면 YES, 그렇지 않으면 NO 를 출력
         */

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        gridFiber = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String[] current = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                gridFiber[i][j] = Integer.parseInt(current[j]);
            }
        }

        for (int param = 0; param < n; param++) {
            if(gridFiber[0][param] == 0) {
                bfs(0, param);
            }
        }

        for (int k = 0; k < n; k++) {
            if(visited[m-1][k]) {
                System.out.println("YES");
                break;
            }
            if(k == n-1) System.out.println("NO");
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] gridSpot = queue.poll();
            int nowX = gridSpot[0];
            int nowY = gridSpot[1];

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + nowX;
                int nextY = dy[i] + nowY;

                if(nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) continue;    // M X N 크기를 넘는지 체크
                if(visited[nextX][nextY]) continue;    // 방문했는지 체크
                if(gridFiber[nextX][nextY] == 1) continue;

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
    }
}
