package Construct_tree_from_inorder_and_preorder_traversal;
// Given two integer arrays preorder and inorder where preorder is the preorder traversal 
// of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

import java.util.HashMap;
import java.util.Map;

// Example 1:

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]


// Example 2:

// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
 

// Constraints:

// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.
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
        int[] pre = {8,10,7,12,4,13,5,9,3,6};
        int[] in =  {7,12,10,4,8,5,13,6,3,9};
        // helper(0, 0, pre.length-1, pre, in);
        int a = in.length;
    }
    Map<Integer,Integer> map = new HashMap<>();
    int index = 0;
    int[] pre;
    int[] in;
    TreeNode init(int[] in, int[] pre, int len){
        this.in = in;
        this.pre = pre;
        for(int i = 0; i < len; i++)
            map.put(in[i], i);
        return treeBuilder(0, len - 1);
    }
    TreeNode treeBuilder(int inStrt, int inEnd){
 
        if(inStrt > inEnd)return null;

        int curr = pre[index++];
        TreeNode node = new TreeNode(curr);
        if (inStrt == inEnd) return node;
        int inIndex = map.get(curr);
 
        node.left = treeBuilder(inStrt, inIndex - 1);
        node.right = treeBuilder(inIndex + 1, inEnd);
        return node;
    } 
    
}
