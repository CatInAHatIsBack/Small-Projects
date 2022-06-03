package Valid_Anagram;

import java.util.HashMap;
import java.util.Map;

class Solution{
//     Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//  typically using all the original letters exactly once.

 

// Example 1:

// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:

// Input: s = "rat", t = "car"
// Output: false
 

// Constraints:

// 1 <= s.length, t.length <= 5 * 104
// s and t consist of lowercase English letters.
 

// Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

    static boolean solution(String s, String t){
        int len = s.length();
        if(len != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len;i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(!map.containsKey(charS)){
                map.put(charS, 1);
            }
            else{
                map.put(charS, map.get(charS)+1);
            }
            if(!map.containsKey(charT)){
                map.put(charT, -1);
            }
            else{
                map.put(charT, map.get(charT)-1);
            }
        }
        for (int val : map.values()) {
            if(val != 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";

        boolean output = solution(s,t);
        System.out.println(output);
    }
}