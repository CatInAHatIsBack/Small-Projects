package Minimum_depth_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along 
// the shortest path from the root node down to the nearest leaf node.

// Note: A leaf is a node with no children.


// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: 2


// Example 2:

// Input: root = [2,null,3,null,4,null,5,null,6]
// Output: 5
 

// Constraints:

// The number of nodes in the tree is in the range [0, 105].
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
    static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        Integer[] arr2 = {2,null,3,null,4,null,5,null,6};
        TreeNode root = new TreeNode();
        root = insertLevelOrder(arr, root, 0);
        // inOrder(root);      
        System.out.println(minDepth(root));
    }
    static int minDepth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);
        int lvl = 1;
        while(!current.isEmpty()){
            int size = current.size();
            while( size-- > 0){
                TreeNode curr = current.poll();  
                if(curr.left == null && curr.right == null){
                    return lvl;
                }
                if(curr.left != null)
                    current.add(curr.left);
                if(curr.right != null)
                    current.add(curr.right);
            }
            lvl++; 
        }
        return 0;
    }
}
