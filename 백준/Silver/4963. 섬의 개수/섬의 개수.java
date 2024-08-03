import java.io.*;
import java.util.*;

public class Main {
    static int width;
    static int height;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            if(width == 0 && height == 0) {
                break;
            }

            map = new int[height][width];
            visited = new boolean[height][width];

            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            count = 0;

            for (int k = 0; k < height; k++) {
                for (int l = 0; l < width; l++) {
                    if (map[k][l] == 1 && !visited[k][l]) {
                        bfs(k, l);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
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

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= height || nextY >= width) continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
    }
}
