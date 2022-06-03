package Implement_Trie;
// A trie (pronounced as "try") or prefix tree is a tree data structure used 
// to efficiently store and retrieve keys in a dataset of strings. There are various 
// applications of this data structure, such as autocomplete and spellchecker.

import java.util.HashMap;
import java.util.Map;

// Implement the Trie class:

// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

// Example 1:

// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output
// [null, null, true, false, true, null, true]

// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True
 

// Constraints:

// 1 <= word.length, prefix.length <= 2000
// word and prefix consist only of lowercase English letters.
// At most 3 * 104 calls in total will be made to insert, search, and startsWith.
public class Solution {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        if(!map.containsKey('d')) System.out.println("asdf");
    } 
    static class Trie{
        static class TrieNode{
            boolean isLast = false;
            Map<Character, TrieNode> map = new HashMap<>();
        }
        static TrieNode root = new TrieNode(); 
        static void insert(String str){
            TrieNode curr = root;
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                curr.map.putIfAbsent(c[i], new TrieNode());
                curr = curr.map.get(c[i]);
            }
            curr.isLast = true;
        }
        static boolean search(String str){
            TrieNode curr = root;
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if(!curr.map.containsKey(c[i]))
                    return false;
                curr = curr.map.get(c[i]);
            }
            return curr.isLast;
        }

        static boolean startsWith(String str){
            TrieNode curr = root;
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if(!curr.map.containsKey(c[i]))
                    return false;
                curr = curr.map.get(c[i]);
            }
            return true;
        }
    }
}
