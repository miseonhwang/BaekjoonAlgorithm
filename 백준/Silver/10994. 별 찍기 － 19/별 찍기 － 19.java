import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받은 숫자만큼 겹쳐지지 않게 포함하는 정사각형 네모를 출력한다
        int input = Integer.parseInt(br.readLine());
        int side = input * 4 - 3; // 네모 한변의 길이
        char[][] nemo = new char[side][side];
        // char 배열에 Arrays.fill() 공백으로 채우기
        for(char[] c : nemo) {
            Arrays.fill(c,' ');
        }
        int idx = 0;
        for(int i = 1; i <= input; i++) {
            for(int j = idx; j < side - idx; j++) {
                nemo[idx][j] = '*';
                nemo[side-idx-1][j] = '*';
                nemo[j][idx] = '*';
                nemo[j][side-idx-1] = '*';
            }
            idx += 2;
        }

        // 출력 for문
        for(int row = 0; row < side; row++) {
            for (int col = 0; col < side; col++) {
                System.out.print(nemo[row][col]);
            }
            System.out.println();
        }
    }
}
