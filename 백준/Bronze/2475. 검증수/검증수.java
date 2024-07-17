import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sprit = br.readLine().split(" ");

        for(int i = 0; i < sprit.length; i++) {
            sum += Math.pow(Integer.parseInt(sprit[i]), 2);
        }
        System.out.println(sum%10);
    }
}
