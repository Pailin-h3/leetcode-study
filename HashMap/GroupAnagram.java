package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {""};

        arrayFunc(strs);
    }

    public static List<List<String>> hashFunc(String[] strs) {
        Map<String,List<String>> hmap = new HashMap<>();

        for(String word: strs){
            char[] chrs = word.toCharArray();
            Arrays.sort(chrs);
            String sortedString = new String(chrs);

            if(!hmap.containsKey(sortedString)){
                hmap.put(sortedString,new ArrayList<>());
            }
            hmap.get(sortedString).add(word);
        }
        return new ArrayList<>(hmap.values());
    }

    public static List<List<String>> arrayFunc(String[] strs) {
        List<List<String>> groupped = new ArrayList<>();
        String[] sorted = new String[strs.length];

        for(int i = 0 ; i<strs.length ; i++){
            if(strs[i].equals("")){
                sorted[i] = "EMPTY";
            }else{
                sorted[i] = sortString(strs[i]);
            }
        }

        System.out.println(Arrays.toString(strs));
        System.out.println(Arrays.toString(sorted));

        for(int i = 0 ; i<sorted.length ; i++){
            if(sorted[i] == "") continue;

            List<String> g = new ArrayList<>();
            if(sorted[i].equals("EMPTY")){
                g.add("");
            }else{
                g.add(strs[i]);
            }
            
            for(int j = i+1 ; j<sorted.length ; j++){
                if(sorted[j] == "") continue;

                System.out.println(sorted[i] + " " + sorted[j]);

                if(sorted[i].equals(sorted[j])){
                    if(sorted[j].equals("EMPTY")){
                        g.add("");
                    }else{
                        g.add(strs[j]);
                    }
                    
                    sorted[j] = "";
                }
            }
            
            sorted[i] = "";
            groupped.add(g);
        }

        for(List<String> g : groupped){
            System.out.println(Arrays.toString(g.toArray()));
        }
        
        return groupped;
    }

    public static String sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
