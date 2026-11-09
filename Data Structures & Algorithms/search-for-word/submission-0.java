class Solution {
    int ROWS, COLS;
    char[][] board;
    String word;
    Set<String> visited = new HashSet<>();
    public boolean exist(char[][] boardIn, String wordIn) {
        board = boardIn;
        word = wordIn;
        ROWS = board.length;
        COLS = board[0].length;

        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(wordSearch(r,c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean wordSearch(int r, int c, int i) {
        if(i == word.length()) {
            return true;
        }

        if(r<0 || c<0 || r>=ROWS || c>=COLS || word.charAt(i) != board[r][c] || visited.contains(r+"#"+c)) {
            return false;
        }
        visited.add(r+"#"+c);
        boolean found = wordSearch(r+1, c, i+1) || wordSearch(r-1, c, i+1) || wordSearch(r, c+1, i+1) || wordSearch(r, c-1, i+1);
        visited.remove(r+"#"+c);

        return found;
    }
}
