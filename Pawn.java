public class Pawn extends ChessPiece {
    public Pawn(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, ChessPiece[][] board) {
        int direction = isWhite ? 1 : -1;
        if (x == newX && board[newX][newY] == null) {
            if (y + direction == newY) {
                return true;
            } else if ((isWhite && y == 1) || (!isWhite && y == 6)) {
                return y + 2 * direction == newY && board[newX][newY - direction] == null;
            }
        } else if (Math.abs(x - newX) == 1 && y + direction == newY && board[newX][newY] != null && board[newX][newY].isWhite() != isWhite) {
            return true;
        }
        return false;
    }
}
