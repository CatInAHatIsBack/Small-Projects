package Binary_tree_max_path_sum;
// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes 
// in the sequence has an edge connecting them. A node can only appear in the sequence at most once. 
// Note that the path does not need to pass through the root.

// The path sum of a path is the sum of the node's values in the path.

// Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

// Example 1:


// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
// Example 2:


// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

// Constraints:

// The number of nodes in the tree is in the range [1, 3 * 104].
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
        Integer[] arr = {1,2,3};
        TreeNode root = new TreeNode();
        root = insertLevelOrder(arr, root, 0);
        System.out.println(maxPathSum(root));
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
    static int max = Integer.MIN_VALUE;
    static int maxPathSum(TreeNode root){
        dfs(root);
        return max;
    }
    static void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        dfs(root.right);
        int left = 0;
        int right = 0;
        if(root.left != null)
            left = root.left.val;
        if(root.right != null)
            right = root.right.val;
        int temp = Math.max(root.val, Math.max(root.val + left, root.val + right));
        int curr = Math.max(root.val + right + left, temp);
        root.val = temp;
        max = Math.max(max, curr);
    }
}
