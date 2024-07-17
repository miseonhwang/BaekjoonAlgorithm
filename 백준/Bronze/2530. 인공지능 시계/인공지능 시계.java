import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] startTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        startTime[2] += Integer.parseInt(br.readLine());

        for(int i = startTime.length-1; i >= 1; i--) {
            if(startTime[i] >= 60) {
                startTime[i-1] += startTime[i] / 60;
                startTime[i] = startTime[i] % 60;
            }
        }

        if(startTime[0] >= 24) {
            startTime[0] %= 24;
        }

        System.out.println(startTime[0] + " " + startTime[1] + " " + startTime[2]);
    }
}
