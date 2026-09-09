import java.util.*;

class Solution {

    Map<String, Integer> dp = new HashMap<>();

    int fun(int i, String s, Map<String, Integer> m1, String tmp) {

        if (i >= s.length()) {
            if (tmp.length() == 0)
                return 1;

            return 0;
        }

        String key = Integer.toString(i) + "+" + tmp;

        if (dp.containsKey(key))
            return dp.get(key);

        tmp += s.charAt(i);

        if (m1.containsKey(tmp)) {
            if (fun(i + 1, s, m1, "") == 1) {
                dp.put(key, 1);
                return 1;
            }
        }

        int m = fun(i + 1, s, m1, tmp);
        
        dp.put(key, m);
        return m;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Map<String, Integer> m1 = new HashMap<>();

        for (String a : wordDict) {
            m1.put(a, m1.getOrDefault(a, 0) + 1);
        }

        dp.clear();

        return fun(0, s, m1, "") == 1;
    }
}