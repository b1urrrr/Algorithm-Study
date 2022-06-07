/*
    백준 11549번 : Identifying Tea
    - 문제 유형 : 구현
*/

import java.util.Scanner;

public class Identifying_Tea {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ans = 0;
        for(int i = 0; i < 5; i++){
            if(sc.nextInt() == t)
                ans += 1;
        }
        System.out.println(ans);
    }
}
