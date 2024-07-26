import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 아는 노래의 개수 n
        int n = Integer.parseInt(st.nextToken());
        // 맞히기를 시도할 노래의 개수 m
        int m = Integer.parseInt(st.nextToken());

        // 노래 제목과 음이름 a 3자리를 해쉬맵에 담는다
        HashMap<String, String> song = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 노래 제목의 길이 t, 노래 제목 s, 해당 노래의 음이름 note 7개
            int t = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String note = "";

            sb = new StringBuilder();
            for (int j = 0; j < 7; j++) {
                sb.append(st.nextToken()) ;
            }
            note = sb.toString();
            // 음이름은 비교할 3자리까지만 담는다
            song.put(s, note.substring(0,3));
        }

        // 노래 음이름 b 3개
        String b = "";
        String answer = "";

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            // 맞히기 시도하는 노래 음이름 b 가 입력될 경우
            for (int i = 0; i < 3; i++) {
                sb.append(st.nextToken());
            }
            // b 에 저장한다
            b = sb.toString();

            // b 에 저장한 음이름이 해쉬맵 value 와 같은 값이 있는지 확인한다
            for (String key : song.keySet()) {
                // 아는 노래 음이름과 같다면
                if (song.get(key).contains(b)) {
                    // 다른 노래제목이 저장되어 있는지 확인하고 없으면 노래제목을 저장한다
                    if (answer.length() == 0) {
                        answer = key;
                    } else {  // 다른 노래제목이 저장되어 있다면 ?를 저장한다
                        answer = "?";
                    }

                }
            }

            if(answer.length() > 0) {
                System.out.println(answer);
            } else {
                System.out.println("!");
            }
            answer = "";
        }
    }
}