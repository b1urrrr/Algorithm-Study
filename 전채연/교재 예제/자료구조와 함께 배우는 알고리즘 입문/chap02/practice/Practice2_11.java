package chap02.practice;

public class Practice2_11 {
    int[][] daysOfYear = {
        {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
        {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    };

    class TMD {
        int y;
        int m;
        int d;

        TMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        TMD after(int n) {
            TMD afterDate = new TMD(y, m, d);
            int isLeap = (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) ? 1 : 0;
            
            afterDate.d += n;
            while (afterDate.d > daysOfYear[isLeap][m]) {
                afterDate.m++;
                afterDate.d -= daysOfYear[isLeap][m];
            }
            return afterDate;
        }
    }
}
