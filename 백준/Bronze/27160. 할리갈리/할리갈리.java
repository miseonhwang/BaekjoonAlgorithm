import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 카드의 개수 N을 입력받아 int 에 저장합니다
        int card = Integer.parseInt(br.readLine());
        // 과일종류와 과일갯수를 저장 할 map을 선언한다
        HashMap<String, Integer> map = new HashMap<>();

        // 카드수만큼 입력을 받는다
        for(int i = 1; i <= card; i++) {
            // 과일종류 S와 과일 개수 X를 입력 받아 String 배열에 저장한다
            String[] strArr = br.readLine().split(" ");
            // S는 String에 X는 int에 저장한다
            String fruitType = strArr[0];
            int fruitNumber = Integer.parseInt(strArr[1]);

            // map을 확인하여 저장된 과일종류가 있는지 확인한다
            if(map.containsKey(fruitType)) {
                // 입력된 과일이 map에 저장되어 있으면 value에 과일갯수를 합한다
                map.put(fruitType, map.get(fruitType) + fruitNumber);
            }else {
                // 입력된 과일이 map에 없다면 추가한다
                map.put(fruitType, fruitNumber);
            }
        }
        // map에 과일갯수가 5가 있다면 YES, 없다면 NO를 출력한다
        if(map.containsValue(5)) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
