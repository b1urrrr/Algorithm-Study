import java.util.Scanner;

public class q11 {
    static class YMD {
        int y; // 년
        int m; // 월 (1 ~ 12)
        int d; // 일 (1 ~ 31)

        public YMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        @Override
        public String toString() {
            return this.y + "년 " + this.m + "월 " + this.d + "일";
        }

        int[][] mdays = {
                {31,28,31,30,31,30,31,31,30,31,30,31}, //평년
                {31,29,31,30,31,30,31,31,30,31,30,31}, //윤년
        };

        int isLeap(int year) {
            return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
        }

        // n일 뒤의 날짜를 반환
        YMD after(int n) {
            YMD temp = new YMD(this.y, this.m, this.d);
            if (mdays[isLeap(temp.y)][temp.m - 1] < temp.d + n) {
                temp.d = temp.d + n - mdays[isLeap(temp.y)][temp.m - 1];
                temp.m++;
            }
            else temp.d = temp.d + n;

            return temp;
        }

        // n일 앞의 날짜를 반환
        YMD before(int n) {
            YMD temp = new YMD(this.y, this.m, this.d);
            if (temp.d - n <= 0) {
                temp.m--;
                temp.d = mdays[isLeap(temp.y)][temp.m - 1] - (n - temp.d);
            }
            else temp.d = temp.d - n;

            return temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("년 : "); int year = sc.nextInt();
        System.out.print("월 : "); int month = sc.nextInt();
        System.out.print("일 : "); int day = sc.nextInt();

        YMD ymd = new YMD(year, month, day);

        System.out.print("몇 일 앞/뒤의 날짜를 구할까요? : "); int num = sc.nextInt();

        System.out.println(num + "일 뒤의 날짜는 : " + ymd.after(num) + "입니다.");

        System.out.println(num + "일 뒤의 날짜는 : " + ymd.before(num) + "입니다.");
    }
}
