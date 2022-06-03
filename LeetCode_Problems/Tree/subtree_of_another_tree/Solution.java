package subtree_of_another_tree;
// Given the roots of two binary trees root and subRoot, return true if 
// there is a subtree of root with the same structure and node values of subRoot and false otherwise.

import javax.swing.tree.TreeNode;

// A subtree of a binary tree tree is a tree that consists of a node in tree 
// and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 
// Example 1:

// Input: root = [3,4,5,1,2], subRoot = [4,1,2]
// Output: true


// Example 2:

// Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
// Output: false
 

// Constraints:

// The number of nodes in the root tree is in the range [1, 2000].
// The number of nodes in the subRoot tree is in the range [1, 1000].
// -104 <= root.val <= 104
// -104 <= subRoot.val <= 104
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
    static boolean isSubTree(TreeNode s, TreeNode t){
        if(t == null) return true;
        if(s == null) return false;

        if(isSameTree(s, t))
            return true;
        return (isSubTree(s.left, t)
            ||  isSubTree(s.right, t));
    }
    static boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        
        if(s != null && t != null &&s.val == t.val)  
            return (isSameTree(s.left, t.left) 
                &&  isSameTree(s.right, t.right));
        return false;
    }
}
