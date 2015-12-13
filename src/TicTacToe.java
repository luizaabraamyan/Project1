import java.util.Scanner;

public class TicTacToe {
	private char[][] gameMatrix;
	private boolean currPlayer2;
	private boolean gameOver;

	private TicTacToe() {
		init();
	}

	private void init() {
		gameMatrix = new char[3][3];
		currPlayer2 = false;
		gameOver = false;

		for (int row = 0; row < gameMatrix.length; row++) {
			for (int col = 0; col < gameMatrix[0].length; col++) {
				gameMatrix[row][col] = ' ';
			}
		}

	}

	private boolean inputPoint(int x, int y) {
		if (x > 3 || x < 1 || y > 3 || y < 1 || this.gameMatrix[x - 1][y - 1] != ' ') {
			return false;
		}
		char move;
		if (this.currPlayer2) {
			move = 'X';
		} else {
			move = 'O';
		}
		this.gameMatrix[x - 1][y - 1] = move;
		this.currPlayer2 = !this.currPlayer2;
		return true;
	}

	private boolean checkForWin() {
		for (int row = 0; row < 3; row++) {
			if (gameMatrix[row][0] != ' ' && gameMatrix[row][0] == gameMatrix[row][1]
					&& gameMatrix[row][1] == gameMatrix[row][2]) {
				return true;
			}
			for (int col = 0; col < 3; col++) {
				if (gameMatrix[0][col] != ' ' && gameMatrix[0][col] == gameMatrix[1][col]
						&& gameMatrix[1][col] == gameMatrix[2][col]) {
					return true;
				}
			}
			if (gameMatrix[0][0] != ' ' && gameMatrix[0][0] == gameMatrix[1][1]
					&& gameMatrix[1][1] == gameMatrix[2][2]) {
				return true;
			}
			if (gameMatrix[0][2] != ' ' && gameMatrix[0][2] == gameMatrix[1][1]
					&& gameMatrix[1][1] == gameMatrix[2][0]) {
				return true;
			}
		}
		return false;
	}

	private void checkForGameEnd(Scanner sc) {
		if (checkForWin() == true) {
			if (currPlayer2) {
				System.out.print("Player1  won.");
			} else {
				System.out.print("Player2  won.");
			}
			askUser(sc);
		} else {
			if (checkForDraw() == true) {
				System.out.print("Draw. ");
				askUser(sc);
			}
		}
	}

	private boolean checkForDraw() {
		for (int row = 0; row < 3; row++) {
			if ( checkThreeCellsForPossible(row,0, row,1, row,2) ) {
				return false;
			}
			for (int col = 0; col < 3; col++) {
				if ( checkThreeCellsForPossible(0,col, 1,col, 2,col)) {
					return false;
				}
			}
			if ( checkThreeCellsForPossible(0,0, 1,1, 2,2)) {
				return false;
			}
			if ( checkThreeCellsForPossible(2,0, 1,1, 0,2)) {
					return false;
			}
		}
		return true;
	}
	
	private boolean checkThreeCellsForPossible(int x1,int y1,int x2,int y2,int x3,int y3){
		return (((int)(gameMatrix[x1][y1] + (int)gameMatrix[x2][y2] + (int)gameMatrix[x3][y3] - ((int)' ')*3 ) % (int)('X' - ' ') == 0)  
			 || ((int)(gameMatrix[x1][y1] + (int)gameMatrix[x2][y2] + (int)gameMatrix[x3][y3] - ((int)' ')*3 ) % (int)('O' - ' ') == 0));
	}

	private void askUser(Scanner sc) {
		System.out.print(" Would you like to start a new game. (yes/no) : ");
		this.gameOver = !sc.next().equalsIgnoreCase("yes");

		if (this.gameOver == false) {
			init();
		}
	}

	public static void playGame() {
		TicTacToe game = new TicTacToe();
		Scanner sc = new Scanner(System.in);
		int coordX, coordY;

		while (game.gameOver == false) {
			do {
				if (game.currPlayer2) {
					System.out.print("Player2");
				} else {
					System.out.print("Player1");
				}
				System.out.print(" enter next coordinates : ");
				coordX = sc.nextInt();
				coordY = sc.nextInt();

			} while (!game.inputPoint(coordX, coordY));

			for (int row = 0; row < game.gameMatrix.length; row++) {
				for (int col = 0; col < game.gameMatrix[0].length; col++) {
					System.out.print("|" + game.gameMatrix[row][col]);
				}
				System.out.println("|");
			}
			game.checkForGameEnd(sc);
		}
		sc.close();
	}
}