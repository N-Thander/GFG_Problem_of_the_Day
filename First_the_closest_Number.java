



class Solution {
    public static int findClosest(int n, int k, int[] arr) 
    {
        int left = 0, right = n -1;
        
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == k)
            {
                return arr[mid];
            }
            else if(arr[mid] < k)
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        
        if (left == 0)
        {
            return arr[0];
        }
        if (left == n)
        {
            return arr[n - 1];
        }
        
        int prev = arr[left - 1];
        int curr = arr[left];
        
        
        if (Math.abs(curr - k) < Math.abs(prev - k))
        {
            return curr;
        }
        else if (Math.abs(curr - k) > Math.abs(prev - k))
        {
            return prev;
        }
        else
        {
            return Math.max(curr, prev);
        }
    }
}
        
