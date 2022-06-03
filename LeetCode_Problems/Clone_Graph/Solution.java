import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
// Given a reference of a node in a connected undirected graph.

// Return a deep copy (clone) of the graph.

// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

// class Node {
//     public int val;
//     public List<Node> neighbors;
// }
 

// Test case format:

// For simplicity, each node's value is the same as the node's index (1-indexed). 
// For example, the first node with val == 1, the second node with val == 2, and so on. 
// The graph is represented in the test case using an adjacency list.

// An adjacency list is a collection of unordered lists used to represent a finite graph. 
// Each list describes the set of neighbors of a node in the graph.

// The given node will always be the first node with val = 1. 
// You must return the copy of the given node as a reference to the cloned graph.

 

// Example 1:


// Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
// Output: [[2,4],[1,3],[2,4],[1,3]]
// Explanation: There are 4 nodes in the graph.
// 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// Example 2:


// Input: adjList = [[]]
// Output: [[]]
// Explanation: Note that the input contains one empty list. 
// The graph consists of only one node with val = 1 and it does not have any neighbors.
// Example 3:

// Input: adjList = []
// Output: []
// Explanation: This an empty graph, it does not have any nodes.
 

// Constraints:

// The number of nodes in the graph is in the range [0, 100].
// 1 <= Node.val <= 100
// Node.val is unique for each node.
// There are no repeated edges and no self-loops in the graph.
// The Graph is connected and all nodes can be visited starting from the given node.


// Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
        public void addEdge(Node n){
            neighbors.add(n);
        }
    }
    /*
        [n1:2,4] [n2:1,3] [n3:4,2] [n4:1,3]
        [n1:null] [n2:null] [n3:null] [n4:null]

    */
    static Node solution(Node input){
        Node[] visited = new Node[5]; 
        Queue<Node> queue = new LinkedList<>();  
        queue.add(input);

        while(queue.peek() != null){
            Node current = queue.poll(); // get node
            int val = current.val;
            if(visited[val] == null) 
                visited[val] = new Node(val);
            for(Node n: current.neighbors){ // itterate its neigh
                if(visited[n.val] == null){ // not visited
                    Node temp = new Node(n.val);
                    visited[n.val] = temp;
                    visited[val].neighbors.add(temp);
                    queue.add(n);
                }
                else{ // visited 
                    visited[val].neighbors.add(visited[n.val]);
                }
            }
        }
        return visited[1];
    }
    static Node solutionFail(Node input){
        Node newNode = new Node(input.val);
        boolean[] visited = new boolean[5]; 
        Queue<Node> queue = new LinkedList<>();  
        queue.add(input);
        Node res = newNode;

        while(queue.peek() != null){
            Node current = queue.poll(); // get node
            for(Node n: current.neighbors){ // itterate its neigh
                if(!visited[n.val]){ // not visited
                    res.neighbors.add(new Node(n.val));
                    queue.add(n);
                }
                else{ // visited 
                    res.neighbors.add(new Node(n.val));
                }
                visited[current.val] = true;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.addEdge(n2);
        n1.addEdge(n4);
        n2.addEdge(n1);
        n2.addEdge(n3);
        n3.addEdge(n2);
        n3.addEdge(n4);
        n4.addEdge(n3);
        n4.addEdge(n1);

        Node output = solution(n1);
        
        
        
    } 
}
