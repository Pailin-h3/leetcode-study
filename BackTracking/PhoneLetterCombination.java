package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombination {
    private static final Map<Character, String[]> phoneLetters;
    static{
        phoneLetters = new HashMap<>();
        phoneLetters.put('2', new String[]{"a","b","c"});
        phoneLetters.put('3', new String[]{"d","e","f"});
        phoneLetters.put('4', new String[]{"g","h","i"});
        phoneLetters.put('5', new String[]{"j","k","l"});
        phoneLetters.put('6', new String[]{"m","n","o"});
        phoneLetters.put('7', new String[]{"p","q","r","s"});
        phoneLetters.put('8', new String[]{"t","u","v"});
        phoneLetters.put('9', new String[]{"w","x","y","z"});
    }

    
    public static void main(String[] args) {
        String digits = "234";

        func(digits);
    }

    public static List<String> func(String digits) {
        List<String> combination = new ArrayList<>();

        if(digits.isEmpty()) return combination;

        dfs(0, digits, "", "", combination);

        System.out.println(Arrays.toString(combination.toArray()));

        return combination;
    }

    private static void dfs(int curr, String digits, String match, String l, List<String> combination){
        match += l;
        if(curr == digits.length()){
            System.out.println("    => " + match);
            combination.add(match);
            return;
        }

        for(String letter : phoneLetters.get(digits.charAt(curr))){
            System.out.printf("%s ", letter);
            dfs(curr+1,  digits, match, letter, combination);
        }
    }
}