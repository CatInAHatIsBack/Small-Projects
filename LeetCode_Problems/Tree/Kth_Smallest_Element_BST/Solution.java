package Kth_Smallest_Element_BST;

import java.util.LinkedList;
import java.util.Queue;

public class Solution{
//     Given the root of a binary search tree, and an integer k, 
// return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 

// Example 1:


// Input: root = [3,1,4,null,2], k = 1
// Output: 1


// Example 2:

// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
 

// Constraints:

// The number of nodes in the tree is n.
// 1 <= k <= n <= 104
// 0 <= Node.val <= 104
 

// Follow up: If the BST is modified often (i.e., we can do insert and delete operations) 
// and you need to find the kth smallest frequently, how would you optimize?

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
        Integer[] input = {5,3,6,2,4,null,null,1};
        TreeNode root = createTree(input);

        
    } 
    static int total = 0;
    static int k = 3;
    static int ans;
    static void dfs(TreeNode root){
        if(root == null || total == k) return;
        dfs(root.left);
        if(++total == k) ans = root.val;
        dfs(root.right); 
    }
}
