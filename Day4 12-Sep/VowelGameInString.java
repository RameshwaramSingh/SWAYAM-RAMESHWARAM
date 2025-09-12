// leetcode ques no 3227
//https://leetcode.com/problems/vowels-game-in-a-string/description/?envType=daily-question&envId=2025-09-12

class Solution {
    public boolean doesAliceWin(String s) {
        int vowel = 0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowel++;
            }
        }
        if(vowel == 0) return false;
        else{
            return true;
        }
    }
}
