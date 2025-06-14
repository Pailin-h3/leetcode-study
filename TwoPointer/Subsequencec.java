package TwoPointer;

public class Subsequencec {
    public static void main(String[] args) {
        String s = "aec";
        String t = "abcde";

        isSubsequence(s, t);
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) return true;
        
        int i = 0;
        int j = 0;

        while(j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            if(i == s.length()){
                System.out.println(true);
                return true;
            }
            j++;
        }

        System.out.println(false);
        return false;
    }
}
