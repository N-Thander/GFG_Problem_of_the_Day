

// User function Template for Java

class Solution {
    static List<Integer> jugglerSequence(int n) 
    {
        // code here
        List<Integer> sequence = new ArrayList<>();
        sequence.add(n);
        
        while (n != 1)
        {
            if (n % 2 == 0)
            {
                  n = (int) Math.sqrt(n);
            }
            else
            {
                 n = (int) Math.pow(n, 1.5);
            }
            sequence.add(n);
        }
        return sequence;
        
    }
}
