class Solution {
    public void setZeroes(int[][] matrix) {
        int rowFirst = 1;

        int col = matrix[0].length;
        int row = matrix.length;
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(matrix[r][c] == 0) {                 
                    if(r>0) {
                        matrix[r][0] = 0;        
                    } else {
                        rowFirst = 0;
                    }
                    matrix[0][c] = 0;
                }
            }
        }
    
    

         for(int r=1; r<row; r++) {
            for(int c=1; c<col; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }

            }
        }
        if(matrix[0][0] == 0) {
            for(int r = 0; r<row; r++) {
                matrix[r][0] = 0;
            }
        }

        if(rowFirst == 0) {
            for(int c = 0; c<col; c++) {
                matrix[0][c] = 0;
            }
        }

        
        
    }
}
