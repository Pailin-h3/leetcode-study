package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        boolean result = func(s, t);
        System.out.println(result);
    }

    public static boolean func(String s, String t) {
        Map<Character, Character> memory = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            
            if(memory.get(s.charAt(i)) == null && memory.get(t.charAt(i)) == null){
                memory.put(s.charAt(i), t.charAt(i));
                memory.put(t.charAt(i), s.charAt(i));
                System.out.println(s.charAt(i) + " mapped to " + t.charAt(i));
            }else if(memory.get(s.charAt(i)) == null || memory.get(t.charAt(i)) == null || memory.get(s.charAt(i)) != t.charAt(i) || memory.get(t.charAt(i)) != s.charAt(i)){
                System.out.println(s.charAt(i) + " mapped to " + t.charAt(i) + " ERROR DUPLICATE");
                return false;
            }
        }

        return true;
    }

    public static boolean func2(String s, String t) {
        Map<Character, Character> memory = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i < s.length() ; i++){
            
            if(memory.get(s.charAt(i)) == null){
                memory.put(s.charAt(i), t.charAt(i));
                if(set.contains(t.charAt(i))){
                    return false;
                }else{
                    set.add(t.charAt(i));
                }

                System.out.println(s.charAt(i) + " mapped to " + t.charAt(i));
            }else if(memory.get(s.charAt(i)) != t.charAt(i)){
                System.out.println(s.charAt(i) + " mapped to " + t.charAt(i) + " ERROR DUPLICATE");
                return false;
            }
        }

        return true;
    }
}
