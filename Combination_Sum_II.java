

// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int[] arr, int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(arr, k, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue; 
            }

            if (target - arr[i] < 0) {
                break; 
            }

            combination.add(arr[i]); 
            backtrack(arr, target - arr[i], i + 1, combination, result); 
            combination.remove(combination.size() - 1); 
        }
    }
}
