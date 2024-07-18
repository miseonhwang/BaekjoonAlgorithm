import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int starDot = Integer.parseInt(br.readLine());

        for(int i = 1; i <= starDot; i++) {
            for(int j = 1; j <= starDot; j++) {
                if(j <= i) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            for(int k = starDot; k >= 1; k--) {
                if(k <= i) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for(int m = starDot-1; m >= 1; m--) {
            for(int n = 1; n <= starDot; n++) {
                if(n <= m) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }

            for(int o = starDot; o >= 1; o--) {
                if(o <= m) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
