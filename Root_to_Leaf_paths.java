

/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root != null) {
            ArrayList<Integer> currentPath = new ArrayList<>();
            findPaths(root, currentPath, paths);
        }
        return paths;
    }
    
    private static void findPaths(Node node, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> paths) {
        if (node == null) {
            return;
        }
        
        // Add current node to the current path
        currentPath.add(node.data);
        
        // If leaf node, add current path to paths list
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(currentPath));
        } else {
            // Recursive calls for left and right subtrees
            findPaths(node.left, new ArrayList<>(currentPath), paths);
            findPaths(node.right, new ArrayList<>(currentPath), paths);
        }
    }
}
        
