import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		char[][] board = new char[3][3];
		
		for(char[] row : board) {
			for(int i=0; i<row.length;i++) {
				row[i]=' ';
			}
		}
		
		char player = 'X';
		boolean gameOver = false;
		
		Scanner scanner = new Scanner(System.in);
		
		while(!gameOver) {
			if(gameOver(board)) {
				System.err.println("Game Over : NoBody won");
				break;
			}
			printBoard(board);
			System.out.println("Player "+player+" enter: ");
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			
			if(board[row][col] == ' ') {
				board[row][col] = player; // place the element
				gameOver = haveWon(board, player);
				
				if(gameOver) {
					System.out.println("Player "+player+" has won.");
				} else {
					player = (player == 'X') ?'O':'X';
				}
			}else {
				System.err.println("Invalid Move. Try Again!");
			}
		}
		printBoard(board);
		scanner.close();
	}
	
	private static boolean haveWon(char[][] board, char player) {
		// TODO Auto-generated method stub
		
		//row validation
		for(int row=0; row < board.length; row++) {
			if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		
		// col validation
		for(int col=0; col < board[0].length; col++) {
			if(board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
		
		// diagonal
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		
		
		return false;
	}

	private static void printBoard(char[][] board) {
		for(char[] row: board) {
			for(int i=0; i<row.length;i++) {
				System.out.print(row[i]+" | ");
			}
			System.out.println();
		}
	}
	
	private static boolean gameOver(char[][] board) {
		for(char[] row: board) {
			for(int i=0; i<row.length;i++) {
				if(row[i] == ' ') {
					return false;
				}
			}
			System.out.println();
		}
		
		return true;
	}
}
