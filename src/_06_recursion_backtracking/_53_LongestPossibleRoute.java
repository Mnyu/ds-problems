package _06_recursion_backtracking;

public class _53_LongestPossibleRoute {
    public int longestPath(int[][] grid, int rows, int cols) {
        if (grid == null) return -1;
        return longestPath(grid, rows, cols, 0, 0, new int[rows][cols],0);

    }

    private int longestPath(int[][] grid, int rows, int cols, int i, int j, int[][] visited, int length) {
        if (i < 0 || i == rows || j < 0 || j == cols || grid[i][j] == 0 || visited[i][j] == 1) {
            return 0;
        }
        if (i == rows - 1 && j == cols - 1) {
            return length;
        }
        visited[i][j] = 1;
        return Math.max(longestPath(grid, rows, cols, i + 1, j, visited,length+1),
                Math.max(longestPath(grid, rows, cols, i, j + 1, visited,length+1),
                        Math.max(longestPath(grid, rows, cols, i - 1, j, visited,length+1),
                                longestPath(grid, rows, cols, i, j - 1, visited,length+1))));

    }

    public static void main(String[] args) {
        // TODO : THIS IS INCORRECT - NEED TO CORRECT IT.
        _53_LongestPossibleRoute obj = new _53_LongestPossibleRoute();
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 1}
        };
        System.out.println(obj.longestPath(grid, 3, 3));

        int[][] grid2 = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        System.out.println(obj.longestPath(grid2, 3, 3));
    }
}
