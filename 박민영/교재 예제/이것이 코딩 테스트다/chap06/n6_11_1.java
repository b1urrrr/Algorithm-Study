// chap06 (3) 실전 문제 : 성적이 낮은 순서로 학생 출력하기 (구글링하면서 푼 것)
// 참고 : https://ponyozzang.tistory.com/404
// 참고 : https://velog.io/@cgw0519/Java-HashMap-Value-%EA%B8%B0%EC%A4%80%EC%9C%BC%EB%A1%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n6_11_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        // map은 순서를 보장하지 않아서 그 자체로는 정렬 불가능함
        // list 형태로 map을 가져와야 함
        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
//        // 방법 1) comparator를 이용해 직접 정의 하기
//        Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });

        // 방법 2) Entry 내장 함수 사용
        list_entries.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> entry : list_entries) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
