
public class Task1 {

	static String encryption(char[][] matrix, String text) {

		char letter1;
		char letter2;
		StringBuilder encryptedText = new StringBuilder();

		for (int firstLetterPosition = 0, secondLetterPosition = 1; secondLetterPosition < text
				.length(); firstLetterPosition += 2, secondLetterPosition += 2) {
			int firstLetterRow = 0;
			int firstLetterCol = 0;
			int secondLetterRow = 0;
			int secondLetterCol = 0;
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

					letter1 = matrix[firstLetterRow][0];
				} else {
					letter1 = matrix[firstLetterRow][firstLetterCol + 1];
				}
				if (secondLetterCol == matrix[0].length - 1) {

					letter2 = matrix[secondLetterRow][0];
				} else {
					letter2 = matrix[secondLetterRow][secondLetterCol + 1];
				}
			}
			if (firstLetterCol == secondLetterCol) {
				if (firstLetterRow == matrix.length - 1) {

					letter1 = matrix[0][firstLetterCol];
				} else {
					letter1 = matrix[firstLetterRow + 1][firstLetterCol];
				}
				if (secondLetterRow == matrix.length - 1) {

					letter2 = matrix[0][secondLetterCol];
				} else {
					letter2 = matrix[secondLetterRow + 1][secondLetterCol];
				}
			}
			encryptedText.append(letter1);
			encryptedText.append(letter2);

		}
		return encryptedText.toString();

	}

	static String decryption(char[][] matrix, String cryptedText, int len) {

		char letter1;
		char letter2;
		StringBuilder decrText = new StringBuilder();

		for (int firstLetterPosition = 0, secondLetterPosition = 1; secondLetterPosition < cryptedText
				.length(); firstLetterPosition += 2, secondLetterPosition += 2) {
			int firstLetterRow = 0;
			int firstLetterCol = 0;
			int secondLetterRow = 0;
			int secondLetterCol = 0;
			letter1 = cryptedText.charAt(firstLetterPosition);
			letter2 = cryptedText.charAt(secondLetterPosition);
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
					firstLetterCol = matrix[firstLetterRow - 1].length;
					letter1 = matrix[firstLetterRow][firstLetterCol];

				} else {
					letter1 = matrix[firstLetterRow][firstLetterCol - 1];
				}
				if (secondLetterCol == 0) {
					secondLetterCol = matrix[firstLetterRow - 1].length;
					letter2 = matrix[secondLetterRow][secondLetterCol];
				} else {
					letter2 = matrix[secondLetterRow][secondLetterCol - 1];
				}
			}
			if (firstLetterCol == secondLetterCol) {
				if (firstLetterRow == 0) {
					letter1 = matrix[matrix.length - 1][firstLetterCol];
				} else {
					letter1 = matrix[firstLetterRow - 1][firstLetterCol];
				}
				if (secondLetterRow == 0) {
					letter2 = matrix[matrix.length - 1][secondLetterCol];
				} else {
					letter2 = matrix[secondLetterRow - 1][secondLetterCol];
				}
			}
			decrText.append(letter1);
			decrText.append(letter2);

		}
		if (decrText.length() != len) {
			decrText.deleteCharAt(decrText.length() - 1);
		}
		return decrText.toString();

	}
}
