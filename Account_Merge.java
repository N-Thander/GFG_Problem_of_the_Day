
class Solution 
{
    class DSU
    {
        private int[] parent;
        private int[] rank;
        
        public DSU(int size)
        {
            parent = new int[size];
            rank = new int[size];
            
            for(int i = 0; i < size; i++)
            {
                parent[i] = i;
            }
        }
        
        public int find(int x)
        {
            if(parent[x] != x)
            {
                parent[x] = find(parent[x]);
            }
            
            return parent[x];
        }
        
        public void union(int x, int y)
        {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY)
            {
                if (rank[rootX] > rank[rootY])
                {
                    parent[rootY] = rootX;
                }
                else if (rank[rootX] < rank[rootY])
                {
                    parent[rootX] = rootY;
                }
                else 
                {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) 
    {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> emailToID = new HashMap<>();
        
        for(int i = 0; i < n; i++)
        {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            for(int j = 1; j < account.size(); j++)
            {
                String email = account.get(j);
                if(!emailToID.containsKey(email))
                {
                    emailToID.put(email, i);
                }
                else
                {
                    dsu.union(i, emailToID.get(email));
                }
            }
        }
        
        Map<Integer, List<String>> components = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToID.entrySet())
        {
            String email = entry.getKey();
            int id = dsu.find(entry.getValue());
            components.computeIfAbsent(id, k -> new ArrayList<>()).add(email);
        }
        
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : components.entrySet())
        {
            int id = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(id).get(0));
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
            
        }
        
        return result;
        
    }
}
     
