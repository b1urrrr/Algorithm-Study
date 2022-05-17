// chap03 (1) 예제3-1 : 거스름돈

public class n3_1 {
    public static void main(String[] args) {
        int n = 1260;
        int cnt = 0;
        // 큰 단위의 화폐부터 차례대로 확인
        int[] cointTypes = {500, 100, 50, 10};

        for (int i = 0; i < 4; i++) {
            int coin = cointTypes[i];
            cnt += n / coin;
            n %= coin;
        }

        System.out.println(cnt);
    }
}
