/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

/*
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> lr = new Stack<>(); // left to right
        Stack<Node> rl = new Stack<>(); // right to left
        lr.push(root);
        while (!lr.isEmpty() || !rl.isEmpty()) {
            // Process left to right
            while (!lr.isEmpty()) {
                Node curr = lr.pop();
                res.add(curr.data);
                // push children in order: left → right
                if (curr.left != null) rl.push(curr.left);
                if (curr.right != null) rl.push(curr.right);
            }
            // Process right to left
            while (!rl.isEmpty()) {
                Node curr = rl.pop();
                res.add(curr.data);
                // push children in order: right → left
                if (curr.right != null) lr.push(curr.right);
                if (curr.left != null) lr.push(curr.left);
            }
        }
        return res;
    }
}
