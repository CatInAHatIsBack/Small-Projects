package Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
//  Given an array of strings strs, group the anagrams together.
//  You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters
// of a different word or phrase, typically using all the original letters exactly once.

 

// Example 1:

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]


// Example 2:

// Input: strs = [""]
// Output: [[""]]


// Example 3:

// Input: strs = ["a"]
// Output: [["a"]]
 

// Constraints:

// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lowercase English letters.
    static List<List<String>> solution(String[] s){
        Map<String, String> map = new HashMap<>(); 
        sort(s,map);

        Map<String, List<String>> result = new HashMap<>(); 
        for (String string : s) {
            String sorted = map.get(string);
            result.putIfAbsent(sorted, new ArrayList<String>());
            result.get(sorted).add(string);

        }

        return new ArrayList<>(result.values());
    }
    static void sort(String[] s, Map<String,String> map){
        for (String string : s) {
            char[] arr = string.toCharArray(); 
            Arrays.sort(arr);
            map.put(string, String.valueOf(arr));
        }
    }
    public static void main(String[] args) {

        String[] s = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output = solution(s);
        for (List<String> list : output) {
            for (String a: list) {
                System.out.print(a);
            } 
            System.out.println();
        }
    }

}
