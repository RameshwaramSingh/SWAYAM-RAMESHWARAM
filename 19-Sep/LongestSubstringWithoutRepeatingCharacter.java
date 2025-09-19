//leetcode ques no 3
https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
       int start = 0;
       int end = 0;
       int maxLength = 0;
       ArrayList<Character> list = new ArrayList<>();
       while(end<s.length()){
        if(!list.contains(s.charAt(end))){
            list.add(s.charAt(end));
            maxLength = Math.max(maxLength,list.size());
            end++;
        }

        else{
            list.remove(Character.valueOf(s.charAt(start)));
            start++;
        }
       }
       return maxLength;
    }
}
