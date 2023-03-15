/*
 * @author Minyeong Park
 * @date 2023.03.08.
 * DNA 비밀번호
 * 원리 및 코드 참고 : https://www.inflearn.com/course/lecture?courseSlug=%EB%91%90%EC%9E%87-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94&unitId=148345
 * 문제 링크 : https://www.acmicpc.net/problem/12891
 */



import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int result = 0;
        checkArr = new int[4]; // 비밀번호 체크 배열
        myArr = new int[4]; // 현재 상태 배열
        char[] a = new char[s];
        checkSecret = 0; // 현재 p개 중 몇개가 비밀번호 요건에 만족하는지

        a = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++; // i번째 값은 이미 완성됨.
            }
        }

        for (int i = 0; i < p; i++) { // 부분 문자열 처음 받을 때 세팅
            Add(a[i]);  // 현재 상태 배열에 담음
        }

        if (checkSecret == 4) {
            result++;
        }

        // 슬라이딩 윈도우
        for (int i = p; i < s; i++) {
            int j = i - p; // j = 맨 왼쪽, i = 맨 오른쪽
            Add(a[i]); // 오른쪽에 있는 값 추가
            Remove(a[j]);
            if (checkSecret == 4) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) // 같으면 이번에 빠짐으로써 충족이 안 되는 것이니까 checkSecret 하나 줄임
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0])
                    checkSecret++; // 'A'가 더 많이 들어온다고 해서 checkSecret값을 올리면 되는 게 아니므로 딱 같을 때에만 증가시킴
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }


}