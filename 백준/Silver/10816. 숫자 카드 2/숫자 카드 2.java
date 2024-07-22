import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arrN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arrN = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrN);

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < m; j++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(findEndIndex(num) - findStartIndex(num)).append(" ");
        }
        System.out.println(sb);

    }

    public static int findStartIndex(int num) {
        int low = 0;
        int high = n;

        while(low < high) {
            int mid = (low + high) / 2;
            if(num <= arrN[mid]) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findEndIndex(int num) {
        int low = 0;
        int high = n;

        while(low < high) {
            int mid = (low + high) / 2;
            if(num < arrN[mid]) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}