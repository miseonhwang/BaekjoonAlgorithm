import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
     
        int breadNums = input[0];
        int breadPattern = input[1];
        int[][] patternArr = new int[breadNums][breadPattern];

        for(int i = 0; i < breadNums; i++) {
            String[] reverse = br.readLine().split("");

            for(int k = 0; k < breadPattern; k++) {
                System.out.print(reverse[breadPattern - k - 1]);
            }
            System.out.println();
        }
    }
}