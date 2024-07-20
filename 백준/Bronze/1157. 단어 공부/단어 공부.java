import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 대소문자 문자열을 입력받아 char 배열에 저장한다
        char[] chArr = br.readLine().toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            // 문자를 대문자로 변환한다
            chArr[i] = Character.toUpperCase(chArr[i]);
        }

        // map 을 선언한다
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < chArr.length; j++) {
            // map 에 문자와 같은 key 가 있는지 검사한다
            if (map.containsKey(chArr[j])) {
                // key 가 있다면 value 에 값을 증가한다
                map.put(chArr[j], map.get(chArr[j]) + 1);
            } else {
                // key 가 없다면  key, value 를 추가한다
                map.put(chArr[j], 1);
            }
        }

        int max = 0;
        int count = 0;
        char result = ' ';

        // map 에 저장된 value 중에 가장 큰 값을 저장한다
        for(int val : map.values()) {
            max = Math.max(max, val);
        }

        // map 에서 value와 max가 같은 key를 찾는다
        for(Character chKey : map.keySet()) {
            if(map.get(chKey) == max) {
                // value 와 max 값이 같으면 count 를 증가한다
                count++;

                // count 가 1 일 경우 result에 key를 저장한다
                if(count == 1) {
                    result = chKey;
                // count 가 1 이상일 경우 result에 ? 를 저장하고 빠져나온다
                }else if(count > 1) {
                    result = '?';
                    break;
                }
            }
        }
        System.out.println(result);
    }
}