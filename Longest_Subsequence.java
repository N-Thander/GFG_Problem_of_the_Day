
class Solution {
    public static int longestSubseq(int n, int[] a) 
    {
        int [] dp =  new int [n];
        
        for (int i = 0; i < n; i++)
        {
            dp[i] = 1;
        }
        
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if (Math.abs(a[i] - a[j]) == 1)
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLength = 0;
        for(int i = 0; i < n; i++)
        {
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}
