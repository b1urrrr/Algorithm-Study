package chap02;

public class CloneArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = a.clone();
        int[] c = a;
        System.out.println(c.toString());
        
        b[3] = 0;
        c[4] = 0;
        
        System.out.print("a =");
        for (int i = 0; i < a.length; i++)
            System.out.print(" " + a[i]);
        
        System.out.print("\nb =");
        for (int i = 0; i < b.length; i++)
            System.out.print(" " + b[i]);

        System.out.print("\nc =");
        for (int i = 0; i < c.length; i++)
            System.out.print(" " + c[i]);
    }
}
