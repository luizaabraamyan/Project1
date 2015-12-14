import java.util.Scanner;

public class Task1Demo {

	public static void main(String[] args) {
		char[][] matrix = { { 'A', 'I', 'O', 'C', 'P' }, { 'N', 'T', 'E', 'J', 'M' }, { 'D', 'K', 'U', 'G', 'S' },
				{ 'W', 'H', 'R', 'L', 'Y' }, { 'F', 'Q', 'B', 'V', 'X' } };

		Scanner input = new Scanner(System.in);
		System.out.println("Enter some text: ");
		String text = input.next();
		int len = text.length();
		if (text.length() % 2 != 0) {
			text += "A";
		}
		text = text.toUpperCase();
		String encryptedText;
		encryptedText = Task1.encryption(matrix, text);
		System.out.println("Encrypted text: " + encryptedText);
		String decryptedText;
		decryptedText = Task1.decryption(matrix, encryptedText, len);
		System.out.println("Decrypted text: " + decryptedText);
		input.close();

	}
}
