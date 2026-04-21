import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {

        // UC1: Board creation
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        System.out.println("Empty Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // =========================
        // UC2: Toss Logic
        // =========================

        Random random = new Random();

        int toss = random.nextInt(2); // 0 or 1

        char playerSymbol;
        char computerSymbol;
        String currentPlayer;

        if (toss == 0) {
            playerSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = "Player";
        } else {
            playerSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = "Computer";
        }

        // Display result
        System.out.println("\n--- Toss Result ---");
        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentPlayer);
    }
}