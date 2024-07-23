import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 스위치 개수를 입력받아 int 변수에 저장하고 배열을 생성하여 길이를 지정한다
        int switchNumbers = Integer.parseInt(br.readLine());
        int[] switchState = new int[switchNumbers+1];

        // 스위치 상태를 입력받아 생성한 int 배열에 저장한다
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchNumbers; i++) {
            switchState[i] = Integer.parseInt(st.nextToken());
        }

        // 학생수를 입력받아 int 변수에 저장하고 두개의 배열을 생성하여 길이를 지정한다
        int studentNum = Integer.parseInt(br.readLine());
        int[] studentGubun = new int[studentNum];
        int[] studentSwitchNum = new int[studentNum];

        // 성별 스위치 번호를 입력받아 성별 배열과 스위치 번호 배열에 각각 저장한다
        for (int j = 0; j < studentNum; j++) {
            st = new StringTokenizer(br.readLine());
            studentGubun[j] = Integer.parseInt(st.nextToken());
            studentSwitchNum[j] = Integer.parseInt(st.nextToken());
        }

        // 학생들이 순서대로 스위치를 확인하기
        for (int k = 0; k < studentNum; k++) {
            // 학생 성별배열의 0번째 값을 확인한다
            if(studentGubun[k] == 1) {
                // 성별이 1인 경우
                // 숫자 안에서 배수를 찾기
                // 8 길이가 있을 경우
                // 3 을 입력하면 배수는 3, 6 -> 8/3 = 2
                // 2 를 입력하면 배수는 2, 4, 6, 8 -> 8/2 = 4
                for (int l = studentSwitchNum[k]; l <= switchNumbers; l += studentSwitchNum[k]) {
                    // 번호의 배수에 스위치의 상태를 바꾼다
                    if (switchState[l] == 0) {
                        switchState[l] = 1;
                    } else {
                        switchState[l] = 0;
                    }
                }
            }else if(studentGubun[k] == 2) {
                // 성별이 2인 경우
                // 번호를 중심으로 좌우의 스위치상태가 일치하는 구간까지 스위치의 상태값을 바꾼다
                // 스위치 번호 3
                // [2,0] [4,0] 확인 -> 같으면 다음구간 -- 스위치 번호 -1, +1
                // [1,1] [5,1] 확인 -> 배열 마지막 확인
                // 최대 몇 번 돌려야 하는지 8/2 -> 4
                // 스위치 상태 같은 구간 저장할 변수
                int sectionLow = studentSwitchNum[k] - 1;
                int sectionHigh = studentSwitchNum[k] + 1;

                // 배열 길이를 넘지 않는지 확인
                while(sectionLow >= 1 && sectionHigh <= switchNumbers) {
                    if(switchState[sectionLow] != switchState[sectionHigh]) {
                        break;
                    }
                    sectionLow--;
                    sectionHigh++;
                }
                sectionLow++;
                sectionHigh--;

                // 구간에 속한 스위치의 상태를 바꾼다
                for(int n = sectionLow; n <= sectionHigh; n++) {
                    if(switchState[n] == 0) {
                        switchState[n] = 1;
                    }else {
                        switchState[n] = 0;
                    }
                }
            }
        }

        // 스위치 상태를 한줄에 20개씩 출력한다
        for (int out = 1; out <= switchNumbers; out++) {
            System.out.print(switchState[out] + " ");
            if(out % 20 == 0) {
                System.out.println();
            }
        }
    }
}
