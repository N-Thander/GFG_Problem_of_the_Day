





//User function Template for Java

/*  A Binary Tree nodea
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree {
    ArrayList<Integer> noSibling(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        noSiblingHelper(node, result);
        Collections.sort(result); // Sort the result before returning
        cleanupResult(result); // Remove -1 if other valid values are present
        return result;
    }
    
    void noSiblingHelper(Node node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        // Check if the current node has no sibling
        if (node.left != null && node.right == null) {
            result.add(node.left.data);
        }
        if (node.left == null && node.right != null) {
            result.add(node.right.data);
        }
        // Check if both children are null, indicating no sibling
        if (node.left == null && node.right == null && result.isEmpty()) {
            // Add -1 only if the result list is empty
            result.add(-1);
        }
        // Recur for left and right subtrees
        noSiblingHelper(node.left, result);
        noSiblingHelper(node.right, result);
    }
    
    void cleanupResult(ArrayList<Integer> result) {
    if (result.size() >= 2 && result.contains(-1)) {
        result.remove(Integer.valueOf(-1)); // Remove -1 if other valid values are present
    }
}
}
