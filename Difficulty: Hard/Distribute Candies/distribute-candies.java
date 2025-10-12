/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int moves; // keeps track of total moves
    
    public int distCandy(Node root) {
        moves = 0;
        dfs(root);
        return moves;
    }
    
    private int dfs(Node node) {
        if (node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        // total moves is sum of absolute values of left and right excesses
        moves += Math.abs(left) + Math.abs(right);
        
        // return the excess candies to parent
        // (current node’s total candies + left excess + right excess - 1)
        return node.data + left + right - 1;
    }
}