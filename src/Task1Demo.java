
public class Task1Demo {

	public static void main(String[] args) {
		char[][] matrix = { { 'A', 'I', 'O', 'C', 'P' }, { 'N', 'T', 'E', 'J', 'M' }, { 'D', 'K', 'U', 'G', 'S' },
				{ 'W', 'H', 'R', 'L', 'Y' }, { 'F', 'Q', 'B', 'V', 'X' } };

		Scanner input = new Scanner(System.in);
		System.out.println("Enter some text: ");
		String text = input.next();
		String upperText;

		upperText = text.toUpperCase();
		int len = upperText.length();

		if (upperText.length() % 2 != 0) {
			upperText = upperText + "A";
		}

		String getEncryptedText = encryption(matrix, upperText);
		System.out.println("Crypted text: " + getEncryptedText);

		String getDecryptedText = decryption(matrix, getEncryptedText, len);
		System.out.println("Decrypted text: " + getDecryptedText);

		input.close();

	}

}
