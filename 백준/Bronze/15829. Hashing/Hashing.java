import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = 31;
        int m = 1234567891;
        int n = Integer.parseInt(br.readLine());
        BigInteger ans = new BigInteger("0");
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            long ascii = (int) c - 96;
            for (int j = 0; j < i; j++) {
                ascii *= 31;
                ascii %= m;
            }
            BigInteger b = new BigInteger(String.valueOf(ascii));
            ans = ans.add(b);
            ans = ans.remainder(new BigInteger(String.valueOf(m)));
        }
        System.out.print(ans);
    }
}
