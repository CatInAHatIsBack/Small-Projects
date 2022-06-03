import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution{
// Given two strings s and t of lengths m and n respectively, 
// return the minimum window substring of s such that every character 
// in t (including duplicates) is included in the window. 
// If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// A substring is a contiguous sequence of characters within the string.
 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.


// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 

// Constraints:

// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
 

// Follow up: Could you find an algorithm that runs in O(m + n) time?
    static String solution(String s1, String t1){

        char[] s = tochararr(s1);
        char[] t = tochararr(t1);
        if(t.length > s.length ){
            return "";
        }
        int len = s.length;
        int Lpoint = 0;
        Set<Character> set =new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }
        int l = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            char c = s[i];
            if(map.containsKey(c)){
                int val = map.get(c)-1;
                map.put(c, val);
                if(val <= 0){
                    set.add(c);
                }
                while(set.size() == map.size()){
                    char c2 = s[Lpoint];
                    if(map.containsKey(c2)){
                        int val2 = map.get(c2)+1;
                        map.put(c2, val2);
                        if(val2 > 0){
                            set.remove(c2);        
                        }
                    }
                    if(min > i-Lpoint+1){
                        l = Lpoint;
                        min = i-Lpoint+1;
                    }
                    Lpoint++;
                }
            }
        }
        
        if(min != Integer.MAX_VALUE){
            char[] fin = new char[min];
            for (int i = 0; i < min; i++) {
                fin[i] = s[l+i];
            }  
            String res = new String(fin);
            return res;
        }
           
        
        return "";
    }
    static void printMap(Map<Character, Integer> map){
        for (Map.Entry<Character,Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
    public static void main(String[] args) {
        String s = "adobecodebanc";
        String t = "abc";
        
        String output = solution(s,t);
        
        System.out.println(output);
    }
    static char[] tochararr(String s){
        char[] output = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
             output[i] = s.charAt(i);
        }
        return output;
    }
}