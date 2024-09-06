public class Board {
    private ChessPiece[][] board;

    public Board() {
        board = new ChessPiece[8][8];
        setupBoard();
    }

    private void setupBoard() {
        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn(i, 1, true);
            board[i][6] = new Pawn(i, 6, false);
        }
        board[0][0] = new Rook(0, 0, true);
        board[7][0] = new Rook(7, 0, true);
        board[0][7] = new Rook(0, 7, false);
        board[7][7] = new Rook(7, 7, false);

        board[1][0] = new Knight(1, 0, true);
        board[6][0] = new Knight(6, 0, true);
        board[1][7] = new Knight(1, 7, false);
        board[6][7] = new Knight(6, 7, false);

        board[2][0] = new Bishop(2, 0, true);
        board[5][0] = new Bishop(5, 0, true);
        board[2][7] = new Bishop(2, 7, false);
        board[5][7] = new Bishop(5, 7, false);

        board[3][0] = new Queen(3, 0, true);
        board[3][7] = new Queen(3, 7, false);

        board[4][0] = new King(4, 0, true);
        board[4][7] = new King(4, 7, false);
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        ChessPiece piece = board[startX][startY];
        if (piece != null && piece.isValidMove(endX, endY, board)) {
            board[endX][endY] = piece;
            board[startX][startY] = null;
            piece.move(endX, endY);
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int y = 7; y >= 0; y--) {
            for (int x = 0; x < 8; x++) {
                if (board[x][y] == null) {
                    System.out.print(".");
                } else {
                    if (board[x][y] instanceof Pawn) {
                        System.out.print(board[x][y].isWhite() ? "P" : "p");
                    } else if (board[x][y] instanceof Rook) {
                        System.out.print(board[x][y].isWhite() ? "R" : "r");
                    } else if (board[x][y] instanceof Knight) {
                        System.out.print(board[x][y].isWhite() ? "N" : "n");
                    } else if (board[x][y] instanceof Bishop) {
                        System.out.print(board[x][y].isWhite() ? "B" : "b");
                    } else if (board[x][y] instanceof Queen) {
                        System.out.print(board[x][y].isWhite() ? "Q" : "q");
                    } else if (board[x][y] instanceof King) {
                        System.out.print(board[x][y].isWhite() ? "K" : "k");
                    }
                }
            }
            System.out.println();
        }
    }
}
