import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputDice = br.readLine().split(" ");
        int a = Integer.parseInt(inputDice[0]);
        int b = Integer.parseInt(inputDice[1]);
        int c = Integer.parseInt(inputDice[2]);

        if(a == b && a == c) {
            System.out.println(10_000 + a * 1_000);
        } else if(a == b) {
            System.out.println(1_000 + a * 100);
        } else if(b == c) {
            System.out.println(1_000 + b * 100);
        } else if(c == a) {
            System.out.println(1_000 + c * 100);
        } else {
            int max = a;
            if(b > max) max = b;
            if(c > max) max = c;
            System.out.println(max * 100);
        }
    }
}
