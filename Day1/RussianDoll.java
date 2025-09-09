//leetcode ques no 354
https://leetcode.com/problems/russian-doll-envelopes/

import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] env) {
        if (env == null || env.length == 0) return 0;

        // Step 1: Sort by width asc, height desc if widths are equal
        Arrays.sort(env, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        // Step 2: LIS on heights
        int[] dp = new int[env.length];
        int len = 0;

        for (int[] e : env) {
            int h = e[1];

            // Binary search for insertion point
            int l = 0, r = len;
            while (l < r) {
                int m = l+(r-l)/2;  // same as (l + r) / 2
                if (dp[m] < h) l = m + 1;
                else r = m;
            }

            dp[l] = h;
            if (l == len) len++;
        }

        return len;
    }
}
