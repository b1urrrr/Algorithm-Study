/*
    백준 2869번 : 달팽이는 올라가고 싶다
    - 문제 유형 : 수학
*/

import java.io.*;
import java.util.StringTokenizer;

public class 달팽이는_올라가고_싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 입력받음

        int up = Integer.parseInt(st.nextToken()); // 낮에 올라가는 길이
        int down = Integer.parseInt(st.nextToken()); // 밤에 내려가는 길이
        int height = Integer.parseInt(st.nextToken()); // 나무 막대의 높이
        
        // 나무 막대의 높이에서 내려가는 길이를 뺀 값을 활용하면 최소한의 일 수를 계산할 수 있음
        // day = 최소한의 일 수이며,
        // day = 올라갔다가 미끄러진 날들이라고도 할 수 있다. (down + 나머지 값에 대한 처리 필요)
        int day = (height - down) / (up - down);
        
        // 나머지가 있는 경우에만 하루 증가
        /*
                down + 나머지 <= down 이면 이미 마지막으로 올라갔던 날이 day에 포함되어 있기 때문에 계산이 끝남.
                즉, 나머지 <= 0 이면 계산 끝남.
                나머지 > 0 인 경우에만 추가적으로 날을 더해주면 됨.

                down + 나머지 > up 인 경우에만 이틀 이상을 더해야 하는데
                나머지 < up - down 가 성립하기 때문에
                나머지 + down < up 라는 식이 성립한다.
                따라서 down + 나머지 > up 은 참이 될 수 없는 명제이다.
                그러므로 이틀 이상을 더해야 하는 경우는 없고 항상 하루만 더해주면 된다.

                (결론) 나머지 > 0 인 경우에 하루를 더한다.
        */
		if ((height - down) % (up - down) > 0) {
			day++;
		}

        System.out.println(day); // 출력
    }
}
