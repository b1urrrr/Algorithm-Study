package chap07.practice;

import java.util.Arrays;

public class Practice7_5 {
    public class IntSortedSet {
        private int max;
        private int num;
        private int[] set;
    
        public IntSortedSet(int capacity) {
            num = 0;
            max = capacity;
            try {
                set = new int[max];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }
    
        public int capacity() {
            return max;
        }
    
        public int size() {
            return num;
        }
    
        public int indexOf(int n) {
            for (int i = 0; i < num; i++) {
                if (set[i] == n) return i;
            }
            return -1;
        }
    
        public boolean contains(int n) {
            return (indexOf(n) != -1) ? true : false;
        }
    
        public boolean add(int n) {
            if (num >= max || contains(n) == true)
                return false;
            else {
                set[num++] = n;
                Arrays.sort(set);
                return true;
            }
        }
    
        public boolean remove(int n) {
            int idx;
    
            if (num <= 0 || (idx = indexOf(n)) == -1)
                return false;
            else {
                set[idx] = set[--num];
                Arrays.sort(set);
                return true;
            }
        }
    
        public void copyTo(IntSortedSet s) {
            int n = (s.max < num) ? s.max : num;
            for (int i = 0; i < n; i++)
                s.set[i] = set[i];
            Arrays.sort(set);
            s.num = n;
        }
    
        public void copyFrom(IntSortedSet s) {
            int n = (max < s.num) ? max : s.num;
            for (int i = 0; i< n; i++) set[i] = s.set[i];
            Arrays.sort(set);
            num = n;
        }
    
        public boolean equalTo(IntSortedSet s) {
            if (num != s.num)
                return false;
    
            for (int i = 0; i < num; i++) {
                int j = 0;
                for ( ; j < s.num; j++)
                    if (set[i] == s.set[j])
                        break;
                if (j == s.num) // 끝까지 검사한 경우
                    return false;
            }
            return true;
        }
    
        public void unionOf(IntSortedSet s1, IntSortedSet s2) {
            copyFrom(s1);
            for (int i = 0; i < s2.num; i++)
                add(s2.set[i]);
            Arrays.sort(set);
        }
    
        public String toString() {
            StringBuffer temp = new StringBuffer("{ ");
            for (int i = 0; i < num; i++)
                temp.append(set[i] + " ");
            temp.append("}");
            return temp.toString();
        }
    }     
}
