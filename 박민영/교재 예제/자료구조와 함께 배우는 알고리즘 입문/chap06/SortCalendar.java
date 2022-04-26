import java.util.Arrays;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class SortCalendar {
    public static void main(String[] args) {
        GregorianCalendar[] x = {
                new GregorianCalendar(2017, NOVEMBER, 1),
                new GregorianCalendar(1963, OCTOBER, 18),
                new GregorianCalendar(1985, APRIL, 5),
        };

        Arrays.sort(x); // 배열 x를 정렬

        for (int i = 0; i < x.length; i++)
            System.out.printf("%04d년 %02d월 %02d일\n",
                    x[i].get(YEAR),
                    x[i].get(MONTH) + 1,
                    x[i].get(DATE)
            );
    }
}
