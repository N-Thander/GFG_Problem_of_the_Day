

/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, Integer> verticalSumMap = new TreeMap<>();
        verticalSumHelper(root, verticalSumMap, 0);

        for (int sum : verticalSumMap.values()) {
            result.add(sum);
        }
        
        return result;
    }
    
    public void verticalSumHelper(Node node, TreeMap<Integer, Integer> verticalSumMap, int level) {
        if (node == null) {
            return;
        }

        verticalSumMap.put(level, verticalSumMap.getOrDefault(level, 0) + node.data);

        verticalSumHelper(node.left, verticalSumMap, level - 1);

        verticalSumHelper(node.right, verticalSumMap, level + 1);
    }
}
