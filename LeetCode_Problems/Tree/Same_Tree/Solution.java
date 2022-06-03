package Same_Tree;
// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

// Example 1:


// Input: p = [1,2,3], q = [1,2,3]
// Output: true
// Example 2:


// Input: p = [1,2], q = [1,null,2]
// Output: false
// Example 3:


// Input: p = [1,2,1], q = [1,1,2]
// Output: false
 

// Constraints:

// The number of nodes in both trees is in the range [0, 100].
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
    public static void main(String[] args) {

    }
    static boolean isSameTree(TreeNode p, TreeNode q){
        Queue<TreeNode> p1 = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        if(p == null) return q == null;
        if(q == null) return false;
        
        p1.add(p);
        q1.add(q);
        while(!p1.isEmpty() && !q1.isEmpty()){
            p = p1.poll();
            q = q1.poll();
            if(p.val != q.val 
            ||  p.left == null && q.left != null
            ||  p.left != null && q.left == null
            ||  p.right == null && q.right!= null
            ||  p.right != null && q.right == null
            ) return false;
            if(p.left != null && q.left != null){
                p1.add(p.left);
                q1.add(q.left);
            } 
            if(p.right != null && q.right!= null){
                p1.add(p.right);
                q1.add(q.right);
            }
        }
        return p1.isEmpty() && q1.isEmpty();
    }
    
}
