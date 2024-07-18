import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nums = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] numArray = new int[nums];

        int sum = 0;
        int count = 0;

        numArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for(int i = 0; i < numArray.length; i++) {
            sum = 0;
            for(int j = i; j < numArray.length; j++) {
                sum += numArray[j];
                
                if (sum > target) {
                    break;
                } else if (sum == target) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}