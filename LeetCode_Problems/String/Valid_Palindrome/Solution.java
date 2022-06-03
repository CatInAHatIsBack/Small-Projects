package Valid_Palindrome;
// A phrase is a palindrome if, after converting all uppercase 
// letters into lowercase letters and removing all non-alphanumeric characters, 
// it reads the same forward and backward. Alphanumeric characters include letters and numbers.

import java.util.ArrayList;
import java.util.List;

// Given a string s, return true if it is a palindrome, or false otherwise.

 
// Example 1:

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.


// Example 2:

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.


// Example 3:

// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.
 

// Constraints:

// 1 <= s.length <= 2 * 105
// s consists only of printable ASCII characters.

public class Solution {
    static boolean solution(String str){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            
            int a = (str.charAt(i) - 'A') % 32;
            if(str.charAt(i) != '!'& (a < 26 && a >= 0 ) || (a > -18 && a <= -8)){
                list.add(a);
            }
        }
        int Lpoint = 0;
        int Rpoint = list.size() -1;
        while(Lpoint < Rpoint){
            if(list.get(Lpoint) != list.get(Rpoint)){
                return false;
            }
            Lpoint++;
            Rpoint--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 ="Egad! Loretta has Adams as mad as a hatter. Old age!"; 

        System.out.println(solution(s2));
        System.out.println(('/' - 'A') %32);
    }
}
