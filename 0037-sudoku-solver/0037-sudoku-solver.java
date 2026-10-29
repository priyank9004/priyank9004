class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (board[row][col] == '.') {
                    // Try digits '1' through '9'
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // Place the number
                            
                            // Recursively try to solve the rest of the board
                            if (solve(board)) {
                                return true; 
                            }
                            
                            board[row][col] = '.'; // Backtrack if choice failed
                        }
                    }
                    return false; // Return false if no number from 1-9 works here
                }
            }
        }
        return true; // Return true if the whole board is filled successfully
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row constraint
            if (board[row][i] == num) return false;
            
            // Check column constraint
            if (board[i][col] == num) return false;
            
            // Check 3x3 subgrid constraint
            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 9; // Note: i % 3 is functionally identical and safer
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
        }
        return true;
    }
}
