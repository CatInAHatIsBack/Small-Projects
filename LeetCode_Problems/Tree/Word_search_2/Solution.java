package Word_search_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    static class TrieNode{
        boolean isLast = false;
        Map<Character, TrieNode> map = new HashMap<>();
        String word;
    }
    static void insert(String str){
        TrieNode curr = root;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            curr.map.putIfAbsent(c[i], new TrieNode());
            curr = curr.map.get(c[i]);
        }
        curr.isLast = true;
        curr.word = str; 
    }
    public static void main(String[] args) {

        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};
        
        String[] words = {"oath","pea","eat","rain", "hklf", "hf"};
        List<String> res = findWords(board, words);
        for (String s: res) {
            System.out.println(s);    
            System.out.println("sadhf");    
        }
    }    
    static char[][] board;
    static TrieNode root = new TrieNode(); 
    static Set<String> result = new HashSet<>();

    static List<String> findWords(char[][] gboard, String[] words) {
        board = gboard;
        for(String s : words){
            insert(s);
        }
        int rows = board.length; 
        int cols = board[0].length;

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(root, i, j);
            }
        }
        board = gboard;
        return new ArrayList<>(result);
    }
    static void dfs(TrieNode node, int i,int j) {
        if(i < 0 || j < 0 ||
        i > board.length-1 || j > board[0].length -1 ||
        !node.map.containsKey(board[i][j]) || board[i][j] == '!')
           return; 
        char curr = board[i][j];
        board[i][j] = '!';
        node = node.map.get(curr);
        if(node.isLast) {
            result.add(node.word);
        }
        dfs(node,i-1,j); // top
        dfs(node,i,j+1); // right 
        dfs(node,i+1,j); // bot 
        dfs(node,i,j-1); // left 
        board[i][j] = curr;
    }
    
}
