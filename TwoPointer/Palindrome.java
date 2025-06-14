package TwoPointer;

public class Palindrome {
    public static void main(String[] args) {
        String s = "0P";

        func(s);
    }

    private static boolean func(String s){
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s);

        int i = 0;
        int j = s.length();
        if(i==j) return true;

        boolean result = true;
        while(true){
            if(s.charAt(i) != s.charAt(j-1)){
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j-1))){
                    System.out.printf("char at %d [%c] not equal to char at %d [%s]\n", i, s.charAt(i), j, s.charAt(j-1));
                    result = false;
                    break;
                }
            }

            if(j - i <= 2){
                break;
            }
            i++;
            j--;
        }

        System.out.println(result);
        return result;
    }
}
