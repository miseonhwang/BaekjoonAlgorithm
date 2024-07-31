import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            b[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);
        for (int k = 0; k < b.length / 2; k++) {
            int temp = b[k];
            b[k] = b[b.length - 1 - k] ;
            b[b.length - 1 - k] = temp;
        }

        int s = 0;
        for (int q = 0; q < n; q++) {
            s += a[q] * b[q];
        }

        System.out.println(s);
    }

}