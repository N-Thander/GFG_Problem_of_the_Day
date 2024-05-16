
class Solution {
    public int minimumEdgeRemove(int n, int[][] edges) 
    {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] subtreeSize = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        return dfs(1, adj, subtreeSize, visited);
    }

    private int dfs(int node, List<Integer>[] adj, int[] subtreeSize, boolean[] visited) 
    {
        visited[node] = true;
        subtreeSize[node] = 1;
        int removeCount = 0;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                removeCount += dfs(neighbor, adj, subtreeSize, visited);
                subtreeSize[node] += subtreeSize[neighbor];
                // If the subtree size is even, we can consider removing this edge
                if (subtreeSize[neighbor] % 2 == 0) {
                    removeCount++;
                }
            }
        }
        return removeCount;
    }
}
