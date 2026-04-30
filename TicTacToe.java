import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

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
        int toss = random.nextInt(2);

        char playerSymbol = (toss == 0) ? 'X' : 'O';
        char computerSymbol = (toss == 0) ? 'O' : 'X';
        String currentPlayer = (toss == 0) ? "Player" : "Computer";

        System.out.println("\n--- Toss Result ---");
        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentPlayer);

        // =========================
        // Player Move
        // =========================
        int slot = getUserInput();
        int[] pos = convertSlotToIndex(slot);

        if (isValidMove(board, pos[0], pos[1])) {
            placeMove(board, pos[0], pos[1], playerSymbol);
        }

        System.out.println("\nBoard after Player move:");
        printBoard(board);

        // =========================
        // UC7: Computer Move
        // =========================
        computerMove(board, computerSymbol);

        System.out.println("\nBoard after Computer move:");
        printBoard(board);
    }

    // Print Board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // UC3: Input
    public static int getUserInput() {
        int slot;
        while (true) {
            System.out.print("Enter a slot (1-9): ");
            slot = sc.nextInt();
            if (slot >= 1 && slot <= 9) return slot;
            System.out.println("Invalid input! Enter 1–9.");
        }
    }

    // UC4: Convert
    public static int[] convertSlotToIndex(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5: Validate
    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }

    // UC6: Place
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer Random Move
    public static void computerMove(char[][] board, char computerSymbol) {

        int row, col;

        while (true) {
            int slot = random.nextInt(9) + 1; // 1–9
            int[] pos = convertSlotToIndex(slot);

            row = pos[0];
            col = pos[1];

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, computerSymbol);
                System.out.println("\nComputer chose slot: " + slot);
                break;
            }
        }
    }
}