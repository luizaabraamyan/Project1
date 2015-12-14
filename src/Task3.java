
public class Task3 {
	static char[][] knigthMoves(int boardDimX, int boardDimY, int startX, int startY, double waitSeconds,
			boolean outputOnEveryMove) {
		char[][] board = new char[boardDimX][boardDimY];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
		if (validInput(boardDimX, boardDimY, startX, startY)) {
			mapPossibleMoves(board, startX, startY, waitSeconds, outputOnEveryMove);
			if (!outputOnEveryMove) {
				output(board);
			}

		}
		return board;
	}

	private static char[][] mapPossibleMoves(char[][] board, int x, int y, double waitSeconds,
			boolean outputOnEveryMove) {
		if (validInput(board.length, board[0].length, x, y) && board[x][y] != 'X') {
			board[x][y] = 'X';
			if (outputOnEveryMove) {
				output(board);
				wait(waitSeconds);
			}

			for (int index = 0; index < movesArray.length; index++) {
				mapPossibleMoves(board, x + movesArray[index][0], y + movesArray[index][1], waitSeconds,
						outputOnEveryMove);
			}
		}
		return board;
	}

	static private int[][] movesArray = { { 1, 2 }, { 2, -1 }, { 1, -2 }, { -1, 2 }, { 2, 1 }, { -2, -1 }, { -2, 1 },
			{ -1, -2 } };

	private static void output(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print("|" + board[row][col]);
			}
			System.out.println("|");
		}
		System.out.println("");
	}

	private static boolean validInput(int boardDimX, int boardDimY, int startX, int startY) {
		return (boardDimX > startX && boardDimY > startY && startX >= 0 && startY >= 0);
	}

	private static void wait(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
