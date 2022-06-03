import java.util.Arrays;

class Solution{
// A message containing letters from A-Z can be encoded into numbers using the following mapping:

// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"

// To decode an encoded message, all the digits must be grouped then 
// mapped back into letters using the reverse of the mapping above 
// (there may be multiple ways). For example, "11106" can be mapped into:

// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" 
// cannot be mapped into 'F' since "6" is different from "06".

// Given a string s containing only digits, return the number of ways to decode it.

// The test cases are generated so that the answer fits in a 32-bit integer.

 

// Example 1:

// Input: s = "12"
// Output: 2
// Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
// Example 2:

// Input: s = "226"
// Output: 3
// Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
// Example 3:

// Input: s = "06"
// Output: 0
// Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 
    static int solution(String input){
        int len = input.length();
        int[] result = new int[len+1];     
        Arrays.fill(result,0);
        result[len] = 1;
        for (int i = len-1; i >= 0; i--) {
            int c = input.charAt(i) - '0';
            if(c != 0)    
                result[i] += result[i+1];
            
            if(i+1 < len && c == 1 || (c == 2 && input.charAt(i+1)-'0' <=6))
                result[i] += result[i+2];
        } 
        return result[0];
    }
    public static void main(String[] args) {
        String input = "12";
        char c = '3';
        int a = c - '0';
        int output = solution(input);
        System.out.println(output);
        // System.out.println(a);
    }
}