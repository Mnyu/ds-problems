package _06_recursion_backtracking;

import java.util.Arrays;

/**
 * Given : partially filled Sudoku Matrix 9X9
 * Fill the matrix using Sudoku rules.
 */
public class _48_SudokuSolver {

    public int[][] solveSudoku(int[][] a) {
        if (a == null || a.length != 9 || a[0].length != 9) {
            throw new RuntimeException("Sudoku requires a non null 9*9 matrix");
        }
        solveSudoku(a, 0, 0);
        return a;
    }

    private boolean solveSudoku(int[][] a, int i, int j) {
        // Base case - sudoku solved
        if (i == 9) {
            return true;
        }
        // columns are exhausted, move to next row
        if (j == 9) {
            return solveSudoku(a, i + 1, 0);
        }
        //number is given at i, j
        if (a[i][j] != 0) {
            return solveSudoku(a, i, j + 1);
        }
        for (int num = 1; num <= 9; num++) {
            if (canPlaceNum(a, i, j, num)) {
                a[i][j] = num;
                if (solveSudoku(a, i, j + 1)) {
                    return true;
                }
            }
        }
        // THIS IS THE IMPORTANT BACK-TRACKING STEP
        a[i][j] = 0;
        return false;
    }

    private boolean canPlaceNum(int[][] a, int i, int j, int num) {
        return !(isNumPresentInRow(a, i, num)
                || isNumPresentInCol(a, j, num)
                || isNumPresentInSubGrid(a, i, j, num));
    }

    private boolean isNumPresentInRow(int[][] a, int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (a[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumPresentInCol(int[][] a, int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (a[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumPresentInSubGrid(int[][] a, int row, int col, int num) {
        int subGridRowStart = (row / 3) * 3;
        int subGridColStart = (col / 3) * 3;
        for (int i = subGridRowStart; i < subGridRowStart + 3; i++) {
            for (int j = subGridColStart; j < subGridColStart + 3; j++) {
                if (a[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _48_SudokuSolver obj = new _48_SudokuSolver();

        int[][] sudoku = new int[9][9];
        sudoku[0][0] = 5; sudoku[0][1] = 3 ; sudoku[0][4] = 7;
        sudoku[1][0] = 6; sudoku[1][3] = 1; sudoku[1][4] = 9; sudoku[1][5] = 5;
        sudoku[2][1] = 9; sudoku[2][2] = 8; sudoku[2][7] = 6;
        sudoku[3][0] = 8; sudoku[3][4] = 6; sudoku[3][8] = 3;
        sudoku[4][0] = 4; sudoku[4][3] = 8; sudoku[4][5] = 3; sudoku[4][8] = 1;
        sudoku[5][0] = 7; sudoku[5][4] = 2; sudoku[5][8] = 6;
        sudoku[6][1] = 6; sudoku[6][6] = 2; sudoku[6][7] = 8;
        sudoku[7][3] = 4; sudoku[7][4] = 1; sudoku[7][5] = 9; sudoku[7][8] = 5;
        sudoku[8][4] = 8; sudoku[8][7] = 7;
        for(int i = 0 ;i < 9;i++){
            System.out.println(Arrays.toString(obj.solveSudoku(sudoku)[i]));
        }
    }
    // Time Complexity : O(9^(n*m))
    // Space Complexity : O(n*m)
}
