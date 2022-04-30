package chap07.practice;

public class Practice7_2 {
    static class IntSet {
        private int max;
        private int num;
        private int[] set;

        public IntSet(int capacity) {
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
                return true;
            }
        }

        public boolean remove(int n) {
            int idx;

            if (num <= 0 || (idx = indexOf(n)) == -1)
                return false;
            else {
                set[idx] = set[--num];
                return true;
            }
        }

        public void copyTo(IntSet s) {
            int n = (s.max < num) ? s.max : num;
            for (int i = 0; i < n; i++)
                s.set[i] = set[i];
            s.num = n;
        }

        public void copyFrom(IntSet s) {
            int n = (max < s.num) ? max : s.num;
            for (int i = 0; i< n; i++) set[i] = s.set[i];
            num = n;
        }

        public boolean equalTo(IntSet s) {
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

        public void unionOf(IntSet s1, IntSet s2) {
            copyFrom(s1);
            for (int i = 0; i < s2.num; i++)
                add(s2.set[i]);
        }

        public String toString() {
            StringBuffer temp = new StringBuffer("{ ");
            for (int i = 0; i < num; i++)
                temp.append(set[i] + " ");
            temp.append("}");
            return temp.toString();
        }

        // 추가
        public boolean add(IntSet s) {
            boolean isChanged = false;
            for (int i = 0; i < s.num; i++) {
                if (this.add(s.set[i])) 
                    isChanged = true;
            }
            return isChanged;
        }

        public boolean retain(IntSet s) {
            boolean isChanged = false;
            for (int i = 0; i < this.num; i++) {
                if (!s.contains(this.set[i])) {
                    this.remove(this.set[i]);
                    isChanged = true;
                }
            }
            return isChanged;
        }

        public boolean remove(IntSet s) {
            boolean isChanged = false;
            for (int i = 0; i < this.num; i++) {
                if (s.contains(this.set[i])) {
                    this.remove(this.set[i]);
                    isChanged = true;
                }
            }
            return isChanged;
        }
    }
}
