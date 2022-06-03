import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
// Given a string s and a dictionary of strings wordDict, 
// return true if s can be segmented into a space-separated 
// sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.
 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false


    static boolean solution(String in, List<String> dict){
        Map<Character,List<String>> betterDict = makeDict(dict);
        char[] input = in.toCharArray();
        int len = input.length;
        boolean[] result = new boolean[len+1];
        Arrays.fill(result, false);
        result[len] = true;

        for (int i = len-1; i >= 0 ; i--) {
            char c = input[i];
            if(betterDict.containsKey(c)){
                for(String w : betterDict.get(c)){
                    if(i+w.length() <= input.length && checkSub(input, i, w))
                        result[i] = result[i + w.length()];
                    if(result[i])
                        break;
                }
            }
        }
        return result[0];
    }
    static Map<Character,List<String>> makeDict(List<String> dict){
        Map<Character,List<String>> betterDict = new HashMap<>();

        for (String s: dict) {
            char c = s.charAt(0);
            List<String> temp;
            if(betterDict.containsKey(c))
                temp = betterDict.get(c);
            else
                temp = new ArrayList<>();

                temp.add(s);
                betterDict.put(c,temp);
        }
        return betterDict;
 
    }
    static boolean checkSub(char[] input, int start, String s){
        for (int i = 0; i < s.length(); i++) {
            if(input[start + i] != s.charAt(i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String input = "applepenapple";          
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pen");
        boolean output = solution(input, dict);
        System.out.println(output);
    }
    
}
