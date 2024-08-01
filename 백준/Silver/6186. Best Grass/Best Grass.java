import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        
        int count = 0;
        for (int j = 0; j < r; j++) {
            for (int k = 0; k < c; k++) {
                if(graph[j][k] == '#' && !visited[j][k]) {
                    count++;
                    bfs(j, k);
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int l = 0; l < 4; l++) {
                int nextX = nowX + dx[l];
                int nextY = nowY + dy[l];

                if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) continue;
                if (visited[nextX][nextY]) continue;
                if (graph[nextX][nextY] != '#') continue;

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
            }
        }
    }
}