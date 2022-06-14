package chap06;

public class Example6_4 {
    static void quick_sort(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;
        while(left <= right) {
            while (left <= end && array[left] <= array[pivot]) left++;
            while (right > start && array[right] >= array[pivot]) right--;
            // 왼쪽과 오른쪽 인덱스가 엇갈린 경우
            if (left > right) {
                int temp = array[pivot];
                array[pivot] = array[right];
                array[right] = temp;
            } else { // 왼쪽과 오른쪽 인덱스가 엇갈리지 않은 경우
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

            // 왼쪽의 작은 원소들에 대해 퀵 정렬 수행
            quick_sort(array, start, right - 1);
            // 오른쪽의 큰 원소들에 대해 퀵 정렬 수행
            quick_sort(array, right + 1, end);
        }
    }
    public static void main(String[] args) {
        int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quick_sort(array, 0, array.length - 1);
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
