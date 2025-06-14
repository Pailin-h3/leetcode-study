package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        // wordDict.add("sand");
        // wordDict.add("and");
        // wordDict.add("cat");

        // System.out.println(func(s, wordDict));
        func2(s,wordDict);
    }

    public static boolean func(String s, List<String> wordDict) {
        int i = 0;
        int j = s.length();
        while (j > i) {
            System.out.println(s.substring(i, j));
            if(wordDict.contains(s.substring(i, j))){
                System.out.println("MATCH!!");
                i = j;
                j = s.length()+1;
            }
            j--;
        }

        if(j == s.length()) return true;

        return false;
    }

    public static boolean func2(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int max_len = 0;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                System.out.println(s.substring(j, i));
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    System.out.println("Match at " + s.substring(j, i));
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
