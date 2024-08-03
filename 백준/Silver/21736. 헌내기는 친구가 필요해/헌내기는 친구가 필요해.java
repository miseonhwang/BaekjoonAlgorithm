import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int personNum = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * N X M 크기의 캠퍼스에서 사람을 만날수 있는지 탐색
         *
         * 1. 입력
         * 캠퍼스 크기 N, M
         * N 개의 줄에 캠퍼스의 정보 (o 빈공간, x 벽, I 도연이, P 사람)
         *
         * 2. 기능
         * 2-1. 초기화
         * 2-1-0. 캠퍼스 크기의 n x m 크기의 배열과 방문확인 배열을 생성
         * 2-1-1. 도연이의 위치를 저장하는 배열을 생성
         * 2-2. 사람 찾기
         * 2-2-0. 탐색할 위치를 저장하는 queue 생성
         * 2-2-1. 도연이의 위치부터 탐색
         * 2-2-2. 사람이 있는 지 확인
         * 2-2-2-1. 사람이 있다면 personNum 증가
         * 2-2-3. 상, 하, 좌, 우 탐색
         * 2-2-3-0. 탐색한 위치가 캠퍼스 크기를 넘어갈 경우 다른 위치 탐색
         * 2-2-3-1. 탐색한 위치가 방문처리되어 있으면 다른 위치 탐색
         * 2-2-3-2. 탐색할 위치에 X 가 있다면 다른 위치 탐색
         * 2-2-3-3. 탐색할 위치를 queue 에 추가
         * 2-2-3-4. 탐색한 위치는 visited 에 방문처리
         * 3-1. 사람의 수 출력
         *
         * 3. 출력
         * 도연이가 만날 수 있는 사람의 수
         */

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];        // 캠퍼스 크기
        visited = new boolean[n][m];    // 방문햇던 위치
        int[] DoYeon = new int[2];  // 도연이가 있는 위치

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (line.charAt(j) == 'I') {
                    DoYeon[0] = i;
                    DoYeon[1] = j;
                }
            }
        }
        bfs(DoYeon[0], DoYeon[1]);
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            if(map[nowX][nowY] == 'P') {
                personNum++;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || visited[nextX][nextY] == true) continue;
                if (map[nextX][nextY] == 'X') continue;

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
        sb.append(personNum == 0 ? "TT" : personNum);
    }
}
