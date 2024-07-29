import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int max = 0;
            int check = 0;
            //대학이름 배열
            String[] university = new String[n];
            //술 소비량 배열
            int[] drink = new int[n];
            
            // 대학과 한해동안 소비한 술의 양
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                university[j] = st.nextToken();
                drink[j] = Integer.parseInt(st.nextToken());
            }
            
            // max 에 저장된 값과 비교하여 크면 max 에 저장한다
            for(int j = 0; j < n; j++) {
                if(max < drink[j]) {
                    max = drink[j];
                    check = j;
                }
            }
            System.out.println(university[check]);
        }
    }
}
