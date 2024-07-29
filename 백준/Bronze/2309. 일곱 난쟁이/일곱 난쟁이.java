import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 아홉 난쟁이 키를 저장할 배열
        int[] inDwarf = new int[9];
        int heightSum = 0;
        for (int i = 0; i < 9; i++) {
            // 난쟁이의 키를 배열에 저장하고 전부 더한다
            int n = Integer.parseInt(br.readLine());
            inDwarf[i] = n;
            heightSum += inDwarf[i];
        }

        // 난쟁이의 키를 두개씩 빼면서 키의 합이 100이 되는지 확인한다
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (heightSum - inDwarf[i] - inDwarf[j] == 100) {
                    inDwarf[i] = 0;
                    inDwarf[j] = 0;
                    Arrays.sort(inDwarf);
                    for (int k = 2; k < 9; k++) {
                        System.out.println(inDwarf[k]);
                    }
                    return;
                }
            }
        }
    }
}