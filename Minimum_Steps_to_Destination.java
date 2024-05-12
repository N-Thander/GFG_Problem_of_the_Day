
// User function Template for Java

class Solution 
{
    static int minSteps(int d) 
    {
        // code here
        d = Math.abs(d);
        int sum = 0;
        int steps = 0;
        
        while (sum < d || (sum - d) % 2 != 0)
        {
            steps++;
            sum += steps;
        }
        
        return steps;
    }
}
