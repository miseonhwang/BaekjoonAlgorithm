import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            // 빈줄을 받을 변수
            String blank = br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            //세준 세비의 제일 강한 병사의 힘을 저장할 변수
            int Smax = 0;
            int Bmax = 0;

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int S = Integer.parseInt(st.nextToken());
                if(Smax < S) Smax = S;
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int B = Integer.parseInt(st.nextToken());

                if(Bmax < B) Bmax = B;
            }

            // 세준이가 이기면 S, 세비가 이기면 B 를 출력한다
            if(Smax > Bmax) System.out.println("S");
            else if(Bmax > Smax) System.out.println("B");
            else System.out.println("S");
        }
    }
}
