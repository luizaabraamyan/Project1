
public class Task1 {

	public static String encryption(char[][] matrix, String text) {
		int firstLetterPosition = 0;
		int secondLetterPosition = 1;
		char letter1;
		char letter2;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < text.length() / 2; i++) {
			int firstLetterRow = 0, firstLetterCol = 0;
			int secondLetterRow = 0, secondLetterCol = 0;
			letter1 = text.charAt(firstLetterPosition);
			letter2 = text.charAt(secondLetterPosition);
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[0].length; col++) {
					if (letter1 == matrix[row][col]) {
						firstLetterRow = row;
						firstLetterCol = col;
					}
					if (letter2 == matrix[row][col]) {
						secondLetterRow = row;
						secondLetterCol = col;
					}
				}
			}
			if (firstLetterRow != secondLetterRow && firstLetterCol != secondLetterCol) {
				letter1 = matrix[firstLetterRow][secondLetterCol];
				letter2 = matrix[secondLetterRow][firstLetterCol];
			}
			if (firstLetterRow == secondLetterRow) {
				if (firstLetterCol == matrix[0].length - 1) {
					firstLetterCol = 0;
					letter1 = matrix[firstLetterRow][firstLetterCol];

				} else {
					letter1 = matrix[firstLetterRow][++firstLetterCol];
				}
				if (secondLetterCol == matrix[0].length - 1) {
					secondLetterCol = 0;
					letter2 = matrix[secondLetterRow][secondLetterCol];

				} else {
					letter2 = matrix[secondLetterRow][++secondLetterCol];
				}
			}
			if (firstLetterCol == secondLetterCol) {
				if (firstLetterRow == matrix.length - 1) {
					firstLetterRow = 0;
					letter1 = matrix[0][firstLetterCol];
				} else {
					letter1 = matrix[++firstLetterRow][firstLetterCol];
				}
				if (secondLetterRow == matrix.length - 1) {
					secondLetterRow = 0;
					letter2 = matrix[0][secondLetterCol];
				} else {
					letter2 = matrix[secondLetterRow + 1][secondLetterCol];
				}
			}
			str.append(letter1);
			str.append(letter2);
			firstLetterPosition += 2;
			secondLetterPosition += 2;

		}
		return str.toString();

	}

	public static String decryption(char[][] matrix, String text, int length) {
		int firstLetterPosition = 0;
		int secondLetterPosition = 1;
		char letter1;
		char letter2;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < text.length() / 2; i++) {
			int firstLetterRow = 0, firstLetterCol = 0;
			int secondLetterRow = 0, secondLetterCol = 0;
			letter1 = text.charAt(firstLetterPosition);
			letter2 = text.charAt(secondLetterPosition);
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[0].length; col++) {
					if (letter1 == matrix[row][col]) {
						firstLetterRow = row;
						firstLetterCol = col;
					}
					if (letter2 == matrix[row][col]) {
						secondLetterRow = row;
						secondLetterCol = col;
					}
				}
			}
			if (firstLetterRow != secondLetterRow && firstLetterCol != secondLetterCol) {
				letter1 = matrix[firstLetterRow][secondLetterCol];
				letter2 = matrix[secondLetterRow][firstLetterCol];
			}
			if (firstLetterRow == secondLetterRow) {
				if (firstLetterCol == 0) {
					firstLetterCol = 4;
					letter1 = matrix[firstLetterRow][firstLetterCol];

				} else {
					letter1 = matrix[firstLetterRow][--firstLetterCol];
				}
				if (secondLetterCol == 0) {
					secondLetterCol = 4;
					letter2 = matrix[secondLetterRow][secondLetterCol];
				} else {
					letter2 = matrix[secondLetterRow][--secondLetterCol];
				}
			}
			if (firstLetterCol == secondLetterCol) {
				if (firstLetterRow == 0) {
					letter1 = matrix[4][firstLetterCol];
				} else {
					letter1 = matrix[firstLetterRow - 1][firstLetterCol];
				}
				if (secondLetterRow == 0) {
					letter2 = matrix[4][secondLetterCol];
				} else {
					letter2 = matrix[--secondLetterRow][secondLetterCol];
				}
			}
			str.append(letter1);
			str.append(letter2);
			firstLetterPosition += 2;
			secondLetterPosition += 2;

		}
		if (str.length() != length) {
			str.deleteCharAt(str.length() - 1);
		}

		return str.toString();

	}

}
