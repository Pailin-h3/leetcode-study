package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "";
        String t = "";

        func(s, t);

    }

    public static boolean func(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> lib = new HashMap<>();

        for(char c : s.toCharArray()){
            if(lib.get(c) != null){
                lib.put(c, lib.get(c) + 1);
            }else{
                lib.put(c, 1);
            }
        }

        for(char c : t.toCharArray()){
            if(lib.get(c) == null || lib.get(c) == 0){
                return false;
            }else{
                lib.put(c, lib.get(c) - 1);
            }
        }

        return true;
    }

    public static boolean func2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] firstArray = s.toCharArray();
        char[] secondArray = t.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray, secondArray);
    }
}
