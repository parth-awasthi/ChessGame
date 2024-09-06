public class Rook extends ChessPiece {
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, ChessPiece[][] board) {
        if (x != newX && y != newY) return false;
        int xDirection = Integer.signum(newX - x);
        int yDirection = Integer.signum(newY - y);
        int tempX = x + xDirection;
        int tempY = y + yDirection;
        while (tempX != newX || tempY != newY) {
            if (board[tempX][tempY] != null) return false;
            tempX += xDirection;
            tempY += yDirection;
        }
        return board[newX][newY] == null || board[newX][newY].isWhite() != isWhite;
    }
}
