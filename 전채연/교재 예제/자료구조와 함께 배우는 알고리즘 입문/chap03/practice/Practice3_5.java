package chap03.practice;

public class Practice3_5 {
    static int binSearchX(int[] a, int n, int key) {
        int start = 0;
        int end = n - 1;

        do {
            int mid = (start + end) / 2;
            if (a[mid] == key)
                for (int i = mid; i >= 0; i--) if(a[i] != key) return ++i; 
            else if (a[mid] > key) end = mid - 1;
            else start = mid + 1;
        } while (start <= end);

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int n = data.length;
        int key = 7;
        int idx = binSearchX(data, n, key);
        System.out.printf("%d는 a[%d]에 처음으로 있습니다.\n", key, idx);
    }
}
