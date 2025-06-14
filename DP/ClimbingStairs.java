package DP;

public class ClimbingStairs {
    static int a = 1;
    static int b = 2;
    static int c;
    public static void main(String[] args) {
        int n = 3;

        func(n);
    }

    public static int func(int n) {
        if(n <= 2) return n;

        c = a+b;
        a = b;
        b = c;
        func(n-1);

        return c;
    }
}
