

class Solution {
    public int findPeakElement(List<Integer> a) 
    {
        int n = a.size();
        if(n == 0)
        {
            return -1;
        }
        
        int start = 0, end = n - 1;
        
        while (start < end)
        {
            int mid = start + (end - start) / 2;
            
            if (a.get(mid) > a.get(mid + 1))
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        
        return a.get(start);
    }
}
