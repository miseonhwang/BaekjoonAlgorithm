import java.io.*;
import java.util.*;

public class Main {
    static int[][] pixelScreen;
    static int n, m;
    static int t;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pixelScreen = new int[n][m];
        visited = new boolean[n][m];

        double sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                pixelScreen[i][j] = (int)Math.floor(sum/3); // R, G, B 값 평균 초기화
                sum = 0;
            }
        }

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(t <= pixelScreen[i][j]) pixelScreen[i][j] = 255; // T 값 기준 픽셀 초기화
                else pixelScreen[i][j] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(pixelScreen[i][j] == 255 && !visited[i][j]) {  // 픽셀이 255 가 인접한것 카운트
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int nowX = pixel[0];
            int nowY = pixel[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if(visited[nextX][nextY]) continue;
                if(pixelScreen[nextX][nextY] == 0) continue;

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
    }
}
