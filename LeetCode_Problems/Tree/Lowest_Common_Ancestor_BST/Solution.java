package Lowest_Common_Ancestor_BST;
// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

import java.util.LinkedList;
import java.util.Queue;

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

// Example 1:


// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.
// Example 2:


// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// Output: 2
// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
// Example 3:

// Input: root = [2,1], p = 2, q = 1
// Output: 2
 

// Constraints:

// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the BST.
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
        Integer[] input = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = createTree(input); 
        System.out.println();
    } 
    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        while(root != null)
            if(p.val > root.val && q.val > root.val) root = root.right;
            else if(p.val < root.val && q.val < root.val) root = root.left;
            else return root;
        return null;
    }
}
