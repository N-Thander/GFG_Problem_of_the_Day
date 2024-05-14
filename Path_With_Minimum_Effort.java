

class Solution {
    public int MinimumEffort(int rows, int columns, int[][] heights) {

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int[][] minEffort = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                minEffort[i][j] = Integer.MAX_VALUE;
            }
        }
        minEffort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0}); 

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int currentEffort = current[2];

            if (x == rows - 1 && y == columns - 1) {
                return currentEffort;
            }

            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < columns) {

                    int newEffort = Math.max(currentEffort, Math.abs(heights[newX][newY] - heights[x][y]));

                    if (newEffort < minEffort[newX][newY]) {
                        minEffort[newX][newY] = newEffort;
                        pq.offer(new int[]{newX, newY, newEffort});
                    }
                }
            }
        }

        return -1;
    }
}
