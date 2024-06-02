//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int q;
            q = Integer.parseInt(br.readLine());

            int[][] queries = IntMatrix.input(br, q, 2);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.constructList(q, queries);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> constructList(int q, int[][] queries) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int cumulativeXOR = 0;
        
        for (int i = 0; i < q; i++)
        {
            int type = queries[i][0];
            int x = queries[i][1];
            
            if (type == 0)
            {
                list.add(x ^ cumulativeXOR);
            }
            else if(type == 1)
            {
                cumulativeXOR ^= x;
            }
        }
        
        
        for(int j = 0; j < list.size(); j++)
        {
            list.set(j, list.get(j) ^ cumulativeXOR);
        }
        
        Collections.sort(list);
        
        return list;
    }   
    
}
