import java.util.*;

public class WordBreak {
    // followUp Question : ai-bj-ck-dl-em-fn
    // HM : 1278. Palindrome Partitioning III

    // 139
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int len = 0, n = s.length();
        for (String ss : wordDict) {
            set.add(ss);
            len = Math.max(ss.length(), len);
        }

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (!dp[i])
                continue;

            for (int l = 1; l <= len && i + l <= n; l++) {
                String substr = s.substring(i, i + l);
                if (set.contains(substr)) {
                    dp[i + l] = true;
                }
            }
        }
        display(dp);
        return dp[n];
    }

    public static void display(boolean[] dp) {
        for (boolean ele : dp) {
            System.out.print(ele + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("leet");
        list.add("codei");
        System.out.println(wordBreak("leetcode", list));
        
    }
}
