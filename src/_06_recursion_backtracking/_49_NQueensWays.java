package _06_recursion_backtracking;

public class _49_NQueensWays {

    public int noOfWaysNQueens(int n) {
        if (n < 1)
            return 0;
        int[][] board = new int[n][n];
        return noOfWaysNQueens(board, 0, 0, n);
    }

    private int noOfWaysNQueens(int[][] board, int i, int j, int queensRemaining) {
        int n = board.length;
        if (queensRemaining == 0) {
            return 1;
        }
        if (i == n) {
            return 0;
        }
        if (j == n) {
            return noOfWaysNQueens(board, i + 1, 0, queensRemaining);
        }
        if (board[i][j] != 0) {
            return noOfWaysNQueens(board, i, j + 1, queensRemaining);
        }
        placeQueen(board, i, j);
        int waysWithQueenPlaced = noOfWaysNQueens(board, i, j + 1, queensRemaining - 1);
        unPlaceQueen(board, i, j);
        int waysWithoutQueenPlaced = noOfWaysNQueens(board, i, j + 1, queensRemaining);
        return waysWithQueenPlaced + waysWithoutQueenPlaced;
    }

    private void placeQueen(int[][] board, int row, int col) {
        int n = board.length;

        // Rows and Cols = 1
        for (int k = 0; k < n; k++) {
            board[row][k] += 1;
            board[k][col] += 1;
        }

        // Right upper diagonal = 1
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            board[i][j] += 1;
            i--;
            j++;
        }

        // Right lower diagonal = 1
        i = row;
        j = col;
        while (i < n && j < n) {
            board[i][j] += 1;
            i++;
            j++;
        }

        // Left upper diagonal = 1
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            board[i][j] += 1;
            i--;
            j--;
        }

        // Left lower diagonal = 1
        i = row;
        j = col;
        while (i < n && j >= 0) {
            board[i][j] += 1;
            i++;
            j--;
        }
    }

    private void unPlaceQueen(int[][] board, int row, int col) {
        int n = board.length;
        // Rows and Cols = 1
        for (int k = 0; k < n; k++) {
            board[row][k] -= 1;
            board[k][col] -= 1;
        }
        // Right upper diagonal = 1
        int i = row;
        int j = col;
        while (i >= 0 && j < n) {
            board[i][j] -= 1;
            i--;
            j++;
        }
        // Right lower diagonal = 1
        i = row;
        j = col;
        while (i < n && j < n) {
            board[i][j] -= 1;
            i++;
            j++;
        }
        // Left upper diagonal = 1
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            board[i][j] -= 1;
            i--;
            j--;
        }
        // Left lower diagonal = 1
        i = row;
        j = col;
        while (i < n && j >= 0) {
            board[i][j] -= 1;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        _49_NQueensWays obj = new _49_NQueensWays();
        System.out.println(obj.noOfWaysNQueens(1));
        System.out.println(obj.noOfWaysNQueens(2));
        System.out.println(obj.noOfWaysNQueens(3));
        System.out.println(obj.noOfWaysNQueens(4));
        System.out.println(obj.noOfWaysNQueens(5));
        System.out.println(obj.noOfWaysNQueens(6));
        System.out.println(obj.noOfWaysNQueens(7));
        System.out.println(obj.noOfWaysNQueens(8));
        System.out.println(obj.noOfWaysNQueens(9));
        System.out.println(obj.noOfWaysNQueens(10));
    }
}
