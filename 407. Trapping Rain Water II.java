/*
407. Trapping Rain Water II
Solved
Hard
Topics
Companies
Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

 

Example 1:


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.
Example 2:


Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
 

Constraints:

m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 104
*/
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        // initialization
        int[][] vols = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vols[i][j] = heightMap[i][j];
            }
        }

        //spread
        boolean upt = true;
        boolean init = true;
        while (upt) {
            upt = false;
            // from left top
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j], Math.min(vols[i - 1][j], vols[i][j - 1]));
                    if (init || vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
            init = false;

            //from down right
            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j], Math.min(vols[i + 1][j], vols[i][j + 1]));
                    if (vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
        }

        // calculate result
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vols[i][j] > heightMap[i][j])
                    res += vols[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}
