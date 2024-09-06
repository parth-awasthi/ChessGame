public class King extends ChessPiece {
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, ChessPiece[][] board) {
        int dx = Math.abs(newX - x);
        int dy = Math.abs(newY - y);
        return (dx <= 1 && dy <= 1) && (board[newX][newY] == null || board[newX][newY].isWhite() != isWhite);
    }
}
