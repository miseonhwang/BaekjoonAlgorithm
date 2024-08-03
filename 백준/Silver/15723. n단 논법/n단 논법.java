import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> map = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 26; i++) {
            map.add(new ArrayList<>());
        }

        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0);
            st.nextToken();
            int to = st.nextToken().charAt(0);
            map.get(from - 'a').add(to - 'a');  
        }

        int m = Integer.parseInt(br.readLine());
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0);
            st.nextToken();
            int to = st.nextToken().charAt(0);

            System.out.println((dfs(from - 'a', to - 'a') == true) ? "T" : "F");
        }
    }

    public static boolean dfs(int from, int target) {
        int visited[] = new int[26];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(from);
        visited[from] = 1;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int l = 0; l < map.get(now).size(); l++) {
                int nowAlphabet = map.get(now).get(l);
                if(nowAlphabet == target) {
                    return true;
                }
                if(visited[nowAlphabet] == 1) continue;
                visited[nowAlphabet] = 1;
                queue.add(nowAlphabet);
            }
        }
        return false;
    }
}
