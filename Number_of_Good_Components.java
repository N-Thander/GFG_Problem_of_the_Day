


class Solution {
    public boolean bfs(ArrayList<Integer>[] adj, int start, boolean[] vis) {
        int num = 0, edges = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            num++;
            edges += adj[node].size();

            for (int it : adj[node]) {
                if (!vis[it]) {
                    q.offer(it);
                    vis[it] = true;
                }
            }
        }

        return (num * (num - 1) == edges);
    }

    public int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        boolean[] vis = new boolean[v + 1];
        int ans = 0;
        for (int i = 1; i <= v; i++) {
            if (bfs(adj, i, vis)) {
                ans++;
            }
        }
        return ans;
    }
}
