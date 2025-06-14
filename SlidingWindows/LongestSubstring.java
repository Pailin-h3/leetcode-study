package SlidingWindows;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "cdd";

        func(s);
    }

    public static int func(String s) {
        int i = 0;
        int j = 1;

        int maxl = 0;
        while(j<s.length()){
            System.out.printf("i: %d     j: %d\n", i,j);
            System.out.printf("%s\n", s.substring(i, j+1));

            int n = i;
            while(n < j){
                // System.out.printf("%s", s.charAt(n));

                if(s.charAt(n) == s.charAt(j)){
                    maxl = maxl < j-i ? j-i : maxl;
                    i = n + 1;
                    break;
                }else if(n == j-1 && j == s.length()-1){
                    maxl = maxl < j-i+1 ? j-i+1 : maxl;
                }
                n++;
            }
            // System.out.printf("%s", s.charAt(j));
            j++;

            System.out.printf("\n");
        }

        maxl = maxl == 0 ? s.length() : maxl;
        System.out.printf("%d\n", maxl);
        return maxl;
    }
}
