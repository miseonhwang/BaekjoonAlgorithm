import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrInt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println((arrInt[0] + arrInt[1]) % arrInt[2]);
        System.out.println(((arrInt[0] % arrInt[2]) + (arrInt[1] % arrInt[2])) % arrInt[2]);
        System.out.println((arrInt[0] * arrInt[1]) % arrInt[2]);
        System.out.println(((arrInt[0] % arrInt[2]) * (arrInt[1] % arrInt[2])) % arrInt[2]);
    }
}