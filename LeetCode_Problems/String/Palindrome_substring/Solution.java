package Palindrome_substring;

public class Solution {
//     Given a string s, return the number of palindromic substrings in it.

// A string is a palindrome when it reads the same backward as forward.

// A substring is a contiguous sequence of characters within the string.

 

// Example 1:

// Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
// Example 2:

// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

// Constraints:

// 1 <= s.length <= 1000
// s consists of lowercase English letters.
    static int solution(String s){
        int len = s.length();
        int total = 0; 
        for (int i = 0; i < len; i++) {
            int a = numOfPal(i-1,i+1,s); // odd
            int b = numOfPal(i,i+1,s); // even
            total += a+b+1;
        }
        return total;
    }
    static int numOfPal(int i, int j, String s){
        int total = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            total++;
            i--;
            j++;
        }
        return total;
    }
    public static void main(String[] args) {
        String input = "aaa";
        int output = solution(input);
        System.out.println(output);
    }   
}
