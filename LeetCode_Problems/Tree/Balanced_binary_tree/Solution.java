package Balanced_binary_tree;
// Given a binary tree, determine if it is height-balanced.

import java.util.LinkedList;
import java.util.Queue;

// For this problem, a height-balanced binary tree is defined as:

// a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: true
// Example 2:


// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
// Example 3:

// Input: root = []
// Output: true
 

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104
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
    static TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i){
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;
 
            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                                             2 * i + 1);
 
            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                                               2 * i + 2);
        }
        return root;
    }
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = new TreeNode();
        root = insertLevelOrder(arr, root, 0);
        System.out.println(isBalanced(root));
    }
    // static class balancedHeight{
    //     boolean bal;
    //     int height;
    //     balancedHeight(boolean bal, int height){
    //         this.bal = bal;
    //         this.height = height;
    //     }
    // }
    static boolean balanced = true;
    static boolean isBalanced(TreeNode root){

        dfs(root);
        return balanced;
    }
    static int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(right-left) > 1)
            balanced = false;
        return 1 + Math.max(left, right);
    }
    // static balancedHeight dfs(TreeNode root){
    //     if(root == null) return new balancedHeight(true,0);
    //     balancedHeight left = dfs(root.left);
    //     balancedHeight right = dfs(root.right);
    //     boolean balanced = (left.bal && right.bal && Math.abs(left.height - right.height) <= 1); 
    //     return new balancedHeight(balanced, 1+ Math.max(left.height, right.height));
    // }
    
}
