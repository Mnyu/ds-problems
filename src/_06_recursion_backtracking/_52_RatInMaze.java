package _06_recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a an integer N and a grid of size NxN. The cells of the grid are numbered row wise from 1 to N^2.
 * Rat wants to travel from cell number 1 to cell number N^2, and it can move in only right direction or
 * down direction from a particular cell. There is exactly one path from source to
 * destination as some cells are blocked. Help the rat to find the path.
 */
public class _52_RatInMaze {
    public List<Integer> findPath(char[][] grid, int n) {
        List<Integer> path = new ArrayList<>();
        if (grid != null) {
            findPath(grid, n, 0, 0, path);
        }
        return path;
    }
    private boolean findPath(char[][] grid, int n, int i, int j, List<Integer> path) {
        if (i == n || j == n || grid[i][j] == 'X') {
            return false;
        }
        int val = i * n + j + 1;
        path.add(val);
        if (val == n * n) {
            return true;
        }
        boolean isPathPresent = findPath(grid, n, i, j + 1, path) || findPath(grid, n, i + 1, j, path);
        if (!isPathPresent) {
            path.remove(path.size() - 1);
        }
        return isPathPresent;
    }

    public static void main(String[] args) {
        _52_RatInMaze obj = new _52_RatInMaze();
        char[][] grid = new char[][]{
                {'0','0','X','0'},
                {'0','X','0','0'},
                {'0','0','0','X'},
                {'X','X','0','0'}
        };
        System.out.println(obj.findPath(grid,grid.length));
    }
}
