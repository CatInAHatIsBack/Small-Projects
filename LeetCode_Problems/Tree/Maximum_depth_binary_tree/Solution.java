package Maximum_depth_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

class Solution{
// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along 
// the longest path from the root node down to the farthest leaf node.


// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: 3


// Example 2:

// Input: root = [1,null,2]
// Output: 2
 

// Constraints:

// The number of nodes in the tree is in the range [0, 104].
// -100 <= Node.val <= 100

//   Definition for a binary tree node.
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
        TreeNode root = new TreeNode();
        root = insertLevelOrder(arr, root, 0);
        inOrder(root);

        System.out.println(dfs(root, 0, 0));
    }
    static int dfs(TreeNode node, int height, int max){
        height++;
        if(node.left != null)
            max = Math.max(max,dfs(node.left, height, max));
        if(node.right != null)
            max = Math.max(max,dfs(node.right, height, max));
        max = Math.max(max,height);
        return max;
    }

}