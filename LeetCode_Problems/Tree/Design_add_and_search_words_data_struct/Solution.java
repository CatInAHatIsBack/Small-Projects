package Design_add_and_search_words_data_struct;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        
    }
    TrieNode root = new TrieNode(); 
    class TrieNode{
            boolean isLast = false;
            Map<Character, TrieNode> map = new HashMap<>();
    }
    void addWord(String str){
        TrieNode curr = root;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            curr.map.putIfAbsent(c[i], new TrieNode());
            curr = curr.map.get(c[i]);
        }
        curr.isLast = true;
    }
    static char[] word;
    boolean search(String str){
        this.word = str.toCharArray();
        return dfs(root, 0);
    }
    static boolean dfs(TrieNode curr, int j){

        for (int i = j; i < word.length; i++) {
            if (curr == null) return false;
            if(word[i] == '.') {
                for (TrieNode value : curr.map.values()) {
                    if(dfs( value, i)) return true;
                }
            }
            else if(!curr.map.containsKey(word[i]))
                return false;
            curr = curr.map.get(word[i]);
        }
        if(curr == null) return false;
        return curr.isLast;
    }
}
