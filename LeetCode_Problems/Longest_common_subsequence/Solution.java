import java.util.Arrays;

class Solution{
// Given two strings text1 and text2, return the length of their longest common subsequence. 
// If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters 
// (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

 

// Example 1:

// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.
// Example 2:

// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.
// Example 3:

// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.
    // changing from 2d[] to 2 arrays containing current and prev row 
    // will cut space to O(2n) where n is the shortest array
    // space O(n)     
    static int solution(String text1, String text2){ // time = O(n*m) space = O(n*m)
        int n = text1.length();
        int m = text2.length();

        int[][] result = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i],0);
        }
        for (int i = 1; i <= n; i++) {
            char a = text1.charAt(i-1);
            for (int j = 1; j <= m; j++) {
                char b = text2.charAt(j-1);
                if(a==b)
                    result[i][j] = result[i-1][j-1] + 1;
                else
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
            }
        }
        return result[n][m];
    }
    public static void main(String[] args) {

        String text1 = "abcdefesa", text2 = "bfefea";
        int output = solution(text1,text2);
        System.out.println(output);
        
    }
}