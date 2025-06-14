package HashMap;

import java.util.HashMap;
import java.util.Map;

public class RandsomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "abc";

        boolean result = func(ransomNote, magazine);
        System.out.println(result);
    }

    public static boolean func(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();

        for(char c : magazine.toCharArray()){
            if(magazineMap.get(c) == null){
                magazineMap.put(c, 1);
            }else{
                magazineMap.put(c, magazineMap.get(c) + 1);
            }
        }

        for(char c : ransomNote.toCharArray()){
            if(magazineMap.get(c) != null && magazineMap.get(c) > 0){
                magazineMap.put(c, magazineMap.get(c) - 1);
            }else{
                return false;
            }
        }

        return true;
    }
}
