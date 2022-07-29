/*
 * @author Minyeong Park
 * @date 2022.07.29.
 * 덱
 * 문제 링크 : https://www.acmicpc.net/problem/10866
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            switch (comm) {
                case "push_front" :
                    deque.add(0, Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    if (deque.isEmpty())
                        deque.add(0,Integer.parseInt(st.nextToken()));
                    else
                        deque.add(deque.size(), Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!deque.isEmpty())
                        System.out.println(deque.remove(0));
                    else
                        System.out.println(-1);
                    break;
                case "pop_back":
                    if (!deque.isEmpty())
                        System.out.println(deque.remove(deque.size() - 1));
                    else
                        System.out.println(-1);
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    if (deque.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front" :
                    if (!deque.isEmpty())
                        System.out.println(deque.get(0));
                    else
                        System.out.println(-1);
                    break;
                case "back" :
                    if (!deque.isEmpty())
                        System.out.println(deque.get(deque.size() - 1));
                    else
                        System.out.println(-1);
                    break;
            }
        }
    }
}