package Math;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 1213;

        isPalindrome(x);
    }
    
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;

        int bak = x;
        int rev = 0; 
        int rem; 
  
        while (x > 0) { 
            rem = x % 10; 
            rev = (rev * 10) + rem; 
            x = x / 10; 
        } 

        System.out.println(rev);

        return bak == rev;
    }
}
