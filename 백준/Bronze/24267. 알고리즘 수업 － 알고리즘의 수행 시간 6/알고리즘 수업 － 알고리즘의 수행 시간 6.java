import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력받은 수로 등차수열의 합공식을 대입한다
        // N이 50만일때 오버플로우가 나므로 형변환 시켜준다
        System.out.println(n*(n-1L)*(n-2L)/6L);
        System.out.println(3);
    }
}