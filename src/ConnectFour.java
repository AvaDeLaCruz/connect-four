/* 
* Connect 4
* Ava DeLaCruz
* September 15, 2019
*/

import java.util.Scanner;
import java.util.HashMap; 

public class ConnectFour {
	
    public static Scanner scan = new Scanner(System.in);
	private static final int NUMROWS = 6;
	private static final int NUMCOLS = 7;
	private static String[][] board = new String[NUMROWS][NUMCOLS];
	private static HashMap<Integer, Integer> nextSlotMap = new HashMap<>();
	private static int currentPlayer = 1;
	
	
//	initialize the hashmap to map each column number to the next available slot (row number)
//	in the beginning of the game, the first available slot is in the final row (pos NUMROWS-1)
	public static void initializeHashMap() {
		for(int i=0; i<NUMCOLS; i++) {
			nextSlotMap.put(i, NUMROWS-1);
		}
	}
	
//	initialize the connect4 board with all asterisks to represent open slots
	public static void initializeBoard() {
		for(int r = 0; r<NUMROWS; r++) {
			for(int c=0; c<NUMCOLS; c++) {
				board[r][c] = "*";
			}
		}
	}
	
//	print the board, including spaces and pipes
	public static void printBoard() {
		System.out.println();
		for(int r = 0; r<NUMROWS; r++) {
			System.out.print("|");
			for(int c=0; c<NUMCOLS; c++) {
				System.out.print(" " + board[r][c] + " |");
			}
			System.out.println();
		}
		System.out.println();
	}
	
//	prompt the current player to select a column
	public static void promptUser() {
		System.out.print("Player " + currentPlayer + ", which column would you like to use? ");
	}
	
//	check if the chosen column has open slots left
	public static boolean colIsValid(int col) {
//		check if next open slot in given column is a valid slot, i.e. has row value of [0,NUMROWS-1]
		return col > -1 && col < NUMCOLS && (nextSlotMap.get(col) > -1);
	}
	
//	add a disk to the column the user chose
	public static void makeMove(int col) {
//		add current player number to board at pos [nextAvailableRow][col]
		board[nextSlotMap.get(col)][col] = Integer.toString(currentPlayer);
//		update next available slot to be the slot in the row above the current row
		nextSlotMap.replace(col, nextSlotMap.get(col) - 1);
	}
	
//	get player's input col value and either make the move or print an error message
	public static void getMoves() {
		while(true) { //continue game until force quit
			promptUser();
			if(scan.hasNextInt()) { //if user input an int
				int col = scan.nextInt();
				if(colIsValid(col)) { //check if valid col value
					makeMove(col);
					printBoard();
					currentPlayer = (currentPlayer == 1) ? 2 : 1;
				}
				else { //if invalid int input, print error message
					System.out.println("Sorry, that is not a valid option.");
				}
			}
			else { //if invalid non-int input, print error message & clear buffer by storing in string
				System.out.println("Sorry, that is not a valid option.");
				String invalidInput = scan.next();
			}
		}
	}

//	main logic to initiate and run game
	public static void main(String[] args) {
		initializeHashMap();
		initializeBoard();
		printBoard();
		getMoves();	
	}

}
