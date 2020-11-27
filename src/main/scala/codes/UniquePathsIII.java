package codes;

public class UniquePathsIII {
    static int[][] arr = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};

    public static void main(String[] args) {
        System.out.println(uniquePathsIII(arr));
    }

    public static int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return helper(grid, i, j);
                }
            }
        }
        return 0;
    }

    public static int helper(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return 0;
        if (grid[i][j] == 2) {
            if (allTraversed(grid)) return 1;
            else return 0;
        }
        if (grid[i][j] == -1) return 0;
        if (grid[i][j] == 10) return 0;
        grid[i][j] = 10;
        int ret =  helper(grid.clone(), i + 1, j) + helper(grid.clone(), i - 1, j) + helper(grid.clone(), i, j + 1) + helper(grid.clone(), i, j - 1);
        grid[i][j] = 0;
        return ret;
    }

    public static boolean allTraversed(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) return false;
            }
        }
        return true;
    }

    // We can remove allTraversal function and replace it with one variable which gives count of empty places left on each call
    // If that count is 0 and we are at the end then increase unique path else NO.
}
