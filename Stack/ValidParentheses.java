package Stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{()[]}}";
        boolean result = func(s);

        System.out.println(result);
    }

    public static boolean func(String s) {

        Stack<Character> opener = new Stack<>();

        for(char c : s.toCharArray()){
            if(isOpenner(c)){
                opener.push(c);
            }else {
                try{
                    if(!isValidPair(opener.pop(), c)) return false;
                }catch (Exception e){
                    return false;
                }
            }
        }

        return opener.isEmpty();
    }

    private static boolean isOpenner(char c){
        if('(' == c) return true;
        if('[' == c) return true;
        if('{' == c) return true;

        return false;
    }

    private static boolean isValidPair(char o, char c){
        if('(' == o && ')' == c) return true;
        if('[' == o && ']' == c) return true;
        if('{' == o && '}' == c) return true;

        return false;
    }
}
