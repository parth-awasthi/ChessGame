import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard();
            System.out.println("Enter move (e.g., e2 e4): ");
            String move = scanner.nextLine();
            String[] parts = move.split(" ");
            if (parts.length == 2) {
                int startX = parts[0].charAt(0) - 'a';
                int startY = parts[0].charAt(1) - '1';
                int endX = parts[1].charAt(0) - 'a';
                int endY = parts[1].charAt(1) - '1';

                if (board.movePiece(startX, startY, endX, endY)) {
                    System.out.println("Move successful!");
                } else {
                    System.out.println("Invalid move, try again.");
                }
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
    }
}
