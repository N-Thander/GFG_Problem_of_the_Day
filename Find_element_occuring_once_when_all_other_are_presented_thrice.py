class Solution:
    def singleElement(self, arr, N):
        # code here
        count_dict = {}
        
        for i in arr:
            count_dict[i] = count_dict.get(i, 0) + 1
            
        for key, value in count_dict.items():
            if value == 1:
                return key
        
    
