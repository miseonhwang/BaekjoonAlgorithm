import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 채팅방 기록수를 입력받는다
        int log = Integer.parseInt(br.readLine());
        HashSet user = new HashSet();
        int count = 0;

        // 기록수만큼 ENTER, 혹은 채팅을 입력한 유저의 닉네임을 String 에 담는다
        for (int i = 0; i < log; i++) {
            String chat = br.readLine();

            // ENTER 후에 입력한 닉네임을 카운트한다
            if(chat.equals("ENTER")) {
                // hashSet 사이즈를 카운트한다
                count += user.size();
                // 카운트를 초기화한다
                user.clear();
            }else {
                // 닉네임을 hashSet 에 담는다
                user.add(chat);
            }
        }
        System.out.println(count + user.size());
    }
}
