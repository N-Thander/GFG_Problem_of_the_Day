//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Disjoint {
    int[] rank, size, parent;
    
    public Disjoint(int n) {
        rank = new int[n + 1];
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findUltPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findUltPar(parent[node]);
        return parent[node];
    }
    
    public void unionBySize(int u, int v) {
        int ult_u = findUltPar(u);
        int ult_v = findUltPar(v);
        if (ult_u == ult_v) return;
        if (size[ult_u] < size[ult_v]) {
            parent[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        } else {
            parent[ult_v] = ult_u;
            size[ult_u] += size[ult_v];
        }
    }
}

class Solution {
    private boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newc >= 0 && newr < n && newc < n;
    }
    
    public int MaxConnection(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint(n * n);
        int[] delta_row = {-1, 0, 1, 0};
        int[] delta_col = {0, 1, 0, -1};
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    for (int i = 0; i < 4; i++) {
                        int newr = row + delta_row[i];
                        int newc = col + delta_col[i];
                        if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                            int node1 = row * n + col;
                            int node2 = newr * n + newc;
                            ds.unionBySize(node1, node2);
                        }
                    }
                }
            }
        }
        
        int max_size = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    Set<Integer> components = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int newr = row + delta_row[i];
                        int newc = col + delta_col[i];
                        if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                            components.add(ds.findUltPar(newr * n + newc));
                        }
                    }
                    int size_total = 1;
                    for (int component : components) {
                        size_total += ds.size[component];
                    }
                    max_size = Math.max(max_size, size_total);
                }
            }
        }
        
        for (int cell = 0; cell < n * n; cell++) {
            if (grid[cell / n][cell % n] == 1) {
                max_size = Math.max(max_size, ds.size[ds.findUltPar(cell)]);
            }
        }
        
        return max_size;
    }
}
