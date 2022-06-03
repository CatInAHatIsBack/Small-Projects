package serialize_and_deserialize;
// Serialization is the process of converting a data structure or object into a sequence of bits 
// so that it can be stored in a file or memory buffer, or transmitted across a network connection
// link to be reconstructed later in the same or another computer environment.

import java.nio.Buffer;

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction
// on how your serialization/deserialization algorithm should work. You just need to ensure 
// that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// Clarification: The input/output format is the same as how LeetCode serializes a binary tree. 
// You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

// Example 1:


// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]
// Example 2:

// Input: root = []
// Output: []
 

// Constraints:

// The number of nodes in the tree is in the range [0, 104].
// -1000 <= Node.val <= 1000

public class Solution {
    
     static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(Integer val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        String[] a = {"n","n"};
        for (int j = 0; j < a.length; j++) {
            System.out.println(a[j] == "n");
        }

    }
    static StringBuilder builder = new StringBuilder();
    static String serialize(TreeNode root){
        return builder.toString();
    }
    static void dfs(TreeNode root){
        if(root == null) builder.append("n,");
        builder.append(root.val + ",");
        dfs(root.left);
        dfs(root.right);
    }
    static int index = 0;
    static String[] arr;
    static TreeNode deserialize(String string){
        arr = string.split(",",0);
        return dfs2();
    }
    static TreeNode dfs2(){
        if(arr[index] == "n"){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(arr[index]));
        index++;
        node.left = dfs2();
        node.right = dfs2();
        return node;
    }

}
