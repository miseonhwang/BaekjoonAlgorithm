import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        if(check) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    static public void dfs(int x, int y) {
        if (x >= board.length || y >= board.length) {
            return;
        } else if (visited[x][y]) {
            return;
        } else if (board[x][y] == -1) {
            check = true;
            return;
        }

        visited[x][y] = true;

        dfs(x, board[x][y] + y);
        dfs(board[x][y] + x, y);
    }
}