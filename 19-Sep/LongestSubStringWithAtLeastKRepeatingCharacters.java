// leetcode ques no 395
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, k, 0, s.length());
    }

    private int helper(String s, int k, int start, int end) {
        if (end - start < k) return 0; // too short to satisfy condition

        // count frequency of substring [start, end)
        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // split if any char has freq < k
        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                // split string into left and right parts
                int left = helper(s, k, start, i);
                int right = helper(s, k, i + 1, end);
                return Math.max(left, right);
            }
        }

        // if we didn’t split, this substring is valid
        return end - start;
    }
}
