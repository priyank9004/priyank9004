import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the chessboard with empty spaces
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Tracking arrays for O(1) safety checks
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // Track row + col
        boolean[] diag2 = new boolean[2 * n - 1]; // Track col - row + n - 1
        
        backtrack(0, n, board, cols, diag1, diag2, solutions);
        return solutions;
    }
    
    private void backtrack(int row, int n, char[][] board, boolean[] cols, 
                           boolean[] diag1, boolean[] diag2, List<List<String>> solutions) {
        // Base case: All queens are placed successfully
        if (row == n) {
            solutions.add(constructBoard(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = col - row + n - 1;
            
            // If the column or either diagonal is under attack, skip
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            
            // Place the queen
            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;
            
            // Move to the next row
            backtrack(row + 1, n, board, cols, diag1, diag2, solutions);
            
            // Backtrack: Remove the queen and restore state
            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
    
    // Helper method to convert the char array layout into the required list of strings
    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
