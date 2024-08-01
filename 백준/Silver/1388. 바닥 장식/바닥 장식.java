import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] floor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        floor = new char[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            floor[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if(floor[i][j] == '-') {
                    count++;
                    while(j < m && floor[i][j] == '-') {
                        j++;
                    }
                }
            }
        }
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (floor[l][k] == '|') {
                    count++;
                    while(l < n && floor[l][k] == '|') {
                        l++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}