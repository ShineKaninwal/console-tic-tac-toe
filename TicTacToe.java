import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // =========================
        // UC1: Create & Display Board
        // =========================
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        System.out.println("Empty Tic-Tac-Toe Board:");
        printBoard(board);

        // =========================
        // UC2: Toss Logic
        // =========================
        Random random = new Random();
        int toss = random.nextInt(2);

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

        System.out.println("\n--- Toss Result ---");
        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentPlayer);

        // =========================
        // UC3: User Input
        // =========================
        int userSlot = getUserInput();
        System.out.println("You selected slot: " + userSlot);
    }

    // Method to print board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to get user input (1–9)
    public static int getUserInput() {
        int slot;

        while (true) {
            System.out.print("Enter a slot (1-9): ");
            slot = sc.nextInt();

            if (slot >= 1 && slot <= 9) {
                return slot;
            } else {
                System.out.println("Invalid input! Please enter between 1 and 9.");
            }
        }
    }
}