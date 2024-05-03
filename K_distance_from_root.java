

//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
         ArrayList<Integer> result = new ArrayList<>();
         
         distanceKHelper(root, k, 0, result);
         return result;
     }
     
     private void distanceKHelper(Node node, int k, int depth, ArrayList<Integer> result)
     {
         if (node == null)
         {
             return;
         }
         if (depth == k)
         {
             result.add(node.data);
             return;
         }
         
         distanceKHelper(node.left, k, depth + 1, result);
         distanceKHelper(node.right, k, depth + 1, result);
     }
}
