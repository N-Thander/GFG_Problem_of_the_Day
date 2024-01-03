#User function Template for python3

class Solution:
    def smallestSubstring(self, S):
        # Code here
        count = {'0':0, '1': 0, "2":0}
        start = 0
        min_length = float('inf')
        
        for end in range(len(S)):
            count[S[end]] += 1
            
            while all(count.values()):
                min_length = min((min_length, end - start + 1))
                count[S[start]] -= 1
                start += 1
                
            
        return min_length if min_length != float('inf') else -1


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	t=int(input())
	for i in range(t):
		S = input()
		ob = Solution()
		ans = ob.smallestSubstring(S)
		
		print(ans)



# } Driver Code Ends
