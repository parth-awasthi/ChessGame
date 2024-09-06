public abstract class ChessPiece {
    protected int x, y;
    protected boolean isWhite;

    public ChessPiece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isValidMove(int newX, int newY, ChessPiece[][] board);

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}
