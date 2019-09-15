import java.util.Scanner;
import java.util.HashMap; 
import java.util.Map;

public class ConnectFour {
	
	static final int NUMROWS = 6;
	static final int NUMCOLS = 7;
	static char[][] board = new char[NUMROWS][NUMCOLS];
	static HashMap<Integer, Integer> nextSlotMap = new HashMap<>();
	
//	initialize the hashmap to map each column number to the next available slot (row number)
//	in the beginning of the game, the first available slot is in the final row (pos NUMROWS-1)
	public static void initializeHashMap() {
		for(int i=0; i<NUMCOLS; i++) {
			nextSlotMap.put(i, NUMROWS-1);
		}
	}
	
	public static void initializeBoard() {
		for(int r = 0; r<NUMROWS; r++) {
			for(int c=0; c<NUMCOLS; c++) {
				board[r][c] = '*';
			}
		}
		
	}
	
	public static void printBoard() {
		for(int r = 0; r<NUMROWS; r++) {
			System.out.print("|");
			for(int c=0; c<NUMCOLS; c++) {
				System.out.print(" " + board[r][c] + " |");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		initializeHashMap();
		initializeBoard();
		printBoard();
		System.out.println(nextSlotMap);
		
		
	}

}
