import java.util.LinkedList;
import java.util.Queue;

public class Solution{

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
}
