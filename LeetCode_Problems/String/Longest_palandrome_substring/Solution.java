package Longest_palandrome_substring;

public class Solution {
// Given a string s, return the longest palindromic substring in s.


// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.


// Example 2:

// Input: s = "cbbd"
// Output: "bb"
 

// Constraints:

// 1 <= s.length <= 1000
// s consist of only digits and English letters.
    static String solution(String s){
        
        String max = "" ;
        for (int i = 0; i < s.length(); i++) {
            int a = lpc(i-1, i+1, s) + 1; // odd
            if(a > max.length()){
                max = s.substring(i-(a/2), i + a/2+1);
            }
            int b = lpc(i, i+1, s) + 1; // even
            if(b + 1 > max.length()){
                max = s.substring(i-(b/2)+1, i + b/2 +1);
            }
        }
        return max; 
    }
    static int lpc(int i, int j, String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;

        }
        return (j-1) - (i+1);
    }
    public static void main(String[] args) {
        String input = "cbbd";
        String output = solution(input);
        System.out.println(output);
    } 
}
