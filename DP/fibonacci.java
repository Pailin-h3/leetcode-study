package DP;

public class fibonacci {
    static int a = 0;
    static int b = 1;
    static int c;

    public static void main(String[] args) {

    }

    public static int fiboSelf(int n){
        if(n <= 1) return n;

        return fiboSelf(n-1) + fiboSelf(n-2);
    }

    public static int fiboSelfMemo(int n){
        if(n <= 1) return n;

        if(n>1){
            c=a+b;
            a=b;
            b=c;
            fiboSelfMemo(n-1);
        } 
         
      return c;
    }

    public static int fiboDP(int n){
        if(n <= 1) return n;

        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        for(int i = 2 ; i<mem.length ; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }

        return mem[n];
    }
}
