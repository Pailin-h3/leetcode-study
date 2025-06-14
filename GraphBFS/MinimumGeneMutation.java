package GraphBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumGeneMutation {
    public static void main(String[] args) {
        String startGene = "AAAAAAAA";
        String endGene = "CCCCCCCC";
        String[] bank = {"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA","CCCCCCCC"};

        func(startGene, endGene, bank);

    }

    public static int func(String startGene, String endGene, String[] bank) {
        if(Arrays.asList(bank).indexOf(endGene) == -1){
            return -1;
        }
        if(startGene.equals(endGene)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        String[] prevS = new String[bank.length];
        String[] bankBak = new String[bank.length];

        while (!queue.isEmpty()) {
            String q = queue.remove();
            for(int i = 0 ; i<bank.length ; i++){
                if(bank[i].isEmpty()) continue;

                if(canMutate(q, bank[i])){
                    System.out.println("Mutate from " + q + " to " + bank[i]);
                    queue.add(bank[i]);
                    prevS[i] = q;
                    bankBak[i] = bank[i];
                    bank[i] = "";
                }
            }
        }
        System.out.println(Arrays.toString(bankBak));
        System.out.println(Arrays.toString(prevS));

        List<String> path = new ArrayList<>();
        try{
            path = reconstructPath(startGene, endGene, prevS, bankBak);
        }catch(Exception e){
            return -1;
        }

        if(path.isEmpty()) return -1;
        return path.size();
    }

    private static boolean canMutate(String from, String to){
        char[] fromC = from.toCharArray();
        char[] toC = to.toCharArray();
        boolean isDiff = false;
        for(int i = 0 ; i<fromC.length ; i++){
            if(fromC[i] != toC[i]){
                if(isDiff){
                    return false;
                }

                isDiff = true;
            }
        }

        return true;
    }

    private static List<String> reconstructPath(String start, String end, String[] prev, String[] bank){
        List<String> path = new ArrayList<>();

        String at = end;

        while(Arrays.asList(bank).indexOf(at) != -1 && !at.equals(start)){
            System.out.println(at);
            path.add(at);
            at = prev[Arrays.asList(bank).indexOf(at)];
        }

        System.out.println(Arrays.toString(path.toArray()));

        if(canMutate(path.get(path.size()-1), start)){
            return path;
        }

        return new ArrayList<>();
    }
}
