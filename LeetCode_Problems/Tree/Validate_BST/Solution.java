package Validate_BST;
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

import java.util.LinkedList;
import java.util.Queue;

// A valid BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:

// Input: root = [2,1,3]
// Output: true


// Example 2:

// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.
 

// Constraints:

// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1
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
    static TreeNode createTree(Integer[] input){
        Queue<TreeNode> q = new LinkedList(); 
        int index = 1;
        TreeNode root = new TreeNode(input[0]);
        q.add(root);
        while(!q.isEmpty() && index < input.length -1){
            TreeNode curr = q.poll();
            TreeNode left = new TreeNode(input[index++]);
            TreeNode right = new TreeNode(input[index++]);
            curr.left = left;
            q.add(left);
            curr.right = right;
            q.add(right);
        }
        return root;
    }
    static void printInorder(TreeNode root){
        if(root == null) return;
        printInorder(root.left);        
        System.out.print(root.val + ", ");
        printInorder(root.right);
    }
    static void printPreorder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + ", ");
        printInorder(root.left);        
        printInorder(root.right);
    }
    static void printPostorder(TreeNode root){
        if(root == null) return;
        printInorder(root.left);        
        printInorder(root.right);
        System.out.print(root.val + ", ");
    }
    static void printBfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null) continue;
            System.out.print(curr.val+ ", "); 
            q.add(curr.left);
            q.add(curr.right);
        }
    }
    public static void main(String[] args) {
        Integer[] input = {5,1,4,null,null,3,6};
        TreeNode root = createTree(input);
        dfs(root);
        System.out.println(isValid);
        System.out.println();
        System.out.println("In order:");
        printInorder(root);
        System.out.println();
        System.out.println("Pre order:");
        printPreorder(root);
        System.out.println();
        System.out.println("Post order:");
        printPostorder(root);
        System.out.println();
        System.out.println("bfs print:");
        printBfs(root);
        
    }
    static long prev = Long.MIN_VALUE;
    static boolean isValid = true;
    static void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(root.val!= null){
            if(root.val < prev) isValid = false;
            prev = root.val;
        }
        
        dfs(root.right);
    }
}
