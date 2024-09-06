public class Bishop extends ChessPiece {
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    @Override
    public boolean isValidMove(int newX, int newY, ChessPiece[][] board) {
        if (Math.abs(newX - x) != Math.abs(newY - y)) return false;
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
