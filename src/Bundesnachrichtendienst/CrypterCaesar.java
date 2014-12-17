package Bundesnachrichtendienst;
import java.util.ArrayList;
import java.util.List;

/**
 * Caesar Verschlüsselung ordnet jedem Buchstaben im Alphabet Zahlen zu (1-26) und
 * addiert die Wertigkeit eines Schlüssels zu jedem Buchstaben in einer Nachricht dazu.
 * Beim Schlüssel C (Wertigkeit von C = 3) wird jeder Buchstabe in einer Nachricht um 3
 * verschoben. So wird aus 'HALLO' mit Schlüssel = C 'KDOOR'
 * 
 */
class CrypterCaesar extends CrypterClass {

	public CrypterCaesar(String key) throws IllegalKeyException {
		super(key);
		checkKey(key, 1);
	}

	public String encrypt(String message) throws CrypterException {

		message = correctedMessage(message);

		String encryptedMessage = "";
		// Reduziere Key-Bereich auf 1-26
		int index = this.key.charAt(0) - 64;

		// Jeden Buchstaben des Strings verschlüsseln
		for (int i = 0; i < message.length(); i++) {
			encryptedMessage += encryptRek(message.charAt(i), index);
		}

		return encryptedMessage;
	}

	// Rekursive Methode zur Verschiebung der Buchstaben
	private String encryptRek(char character, int index) {

		String temporary = "";

		// Verschiebung der Buchstaben ohne Überlauf
		if ((character + index <= 'Z')) {
			return temporary += (char) (character + index);

			// Verschiebung der Buchstaben mit Überluaf
		} else {

			do {
				// Zähle bis 'Z' hoch
				character++;

				// Reduziere Verschiebung
				index--;

			} while (character != 'Z');

			// Restliche Verschiebung an 'A' dranhängen
			return encryptRek('A', index - 1);
		}

	}

	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> encryptedMessages = new ArrayList<>();

		// Durchlaufe alle Strings
		for (String message : messages) {
			// Füge jeden verschlüsselten String der Liste hinzu
			encryptedMessages.add(encrypt(message));
		}

		return encryptedMessages;
	}

	public String decrypt(String message) throws CrypterException {

		message = correctedMessage(message);

		String decryptedMessage = "";
		// Reduziere Key-Bereich auf 1-26
		int index = this.key.charAt(0) - 64;

		// Jeden Buchstaben des Strings entschlüsseln
		for (int i = 0; i < message.length(); i++) {
			decryptedMessage += decryptRek(message.charAt(i), index);
		}

		return decryptedMessage;
	}

	// Rekursive Methode zur Verschiebung der Buchstaben
	private String decryptRek(char character, int index) {

		String temporary = "";

		// Verschiebung der Buchstaben ohne Überlauf
		if ((character - index >= 'A')) {
			return temporary += (char) (character - index);

			// Verschiebung der Buchstaben mit Überluaf
		} else {

			do {
				// Zähle bis 'A' runter
				character--;

				// Reduziere Verschiebung
				index--;

			} while (character != 'A');

			// Restliche Verschiebung von 'Z' abziehen
			return decryptRek('Z', index - 1);
		}

	}

	public List<String> decrypt(List<String> cypherMessages)
			throws CrypterException {
		List<String> decryptedMessages = new ArrayList<>();

		for (String message : cypherMessages) {
			decryptedMessages.add(decrypt(message));
		}

		return decryptedMessages;
	}
}
