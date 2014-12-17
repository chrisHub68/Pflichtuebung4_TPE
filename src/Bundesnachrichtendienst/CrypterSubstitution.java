package Bundesnachrichtendienst;

import java.util.List;
/**
 * CrypterSubstitution vertauscht jeden Buchstaben einer Nachricht mit 
 * einem Buchstaben aus dem Schlüssel. Jeder Buchstabe hat eine Position im 
 * Alphabet, z.B.: hat 'HALLO' die Positionen 8,1,12,12,15. Ein Schlüssel z.B.:
 * 'YZABCDEFGHIJKLMNOPQRSTUVWX' hat an den Stellen 8,1,12,12,15 die Buchstaben
 * F,Y,J,J,M stehen, so wird aus 'HALLO' nach Substituionsverschlüsselung
 * 'FYJJM'.
 *
 */
class CrypterSubstitution extends CrypterClass {

	// Schl�ssel
	private String[] secretKey;
	// Alphabet
	private String[] alphabet;

	public CrypterSubstitution(String key) throws IllegalKeyException {
		super(key);
		checkKey(key, 26);
		this.secretKey = secretKey(key);
		this.alphabet = alphabet();
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		String encryptedMessage = "";

		// Durchl�uft den String und vertauscht jeden Buchstaben gem�� seiner
		// Postition im Schl�ssel
		for (int i = 0; i < message.length(); i++) {
			// Vertausche Buchstabe mit seiner Position im Schlüssel
			encryptedMessage += secretKey[message.charAt(i) - 'A'];
		}

		return encryptedMessage;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return super.encrypt(messages);
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		String decryptedMessage = "";
		String temp = "";

		// Durchläuft den String und vertauscht jeden Buchstaben gemäß seiner
		// Postition im Alphabet
		for (int i = 0; i < cypherText.length(); i++) {
			for (int j = 0; j < 26; j++) {
				// Suche im Klartext(Alphabet) nach temp
				temp = secretKey[j];

				if (cypherText.charAt(i) == temp.charAt(0)) {

					decryptedMessage += "" + alphabet[j];
				}
			}

		}

		return decryptedMessage;
	}

	@Override
	public List<String> decrypt(List<String> CypherMessages)
			throws CrypterException {
		// TODO Auto-generated method stub
		return super.decrypt(CypherMessages);
	}

	/**
	 * Gibt ein String Array zurück, dass das Alphabet enthält
	 * 
	 * @return String[]
	 */
	private String[] alphabet() {

		String[] alphabet = new String[26];
		char letter = 'A';

		for (int i = 0; i < 26; i++, letter++) {
			alphabet[i] = "" + letter;
		}

		return alphabet;
	}

	/**
	 * Gibt ein String Array zurück, dass einen Schlüssel für die
	 * Substitutionsverschlüsselung enthält
	 * 
	 * @param secretKey
	 * @return String[]
	 */
	private String[] secretKey(String secretKey) {

		String[] secretArray = new String[26];
		//Alle Werte durchlaufen und anhängen 
		for (int i = 0; i < 26; i++) {
			secretArray[i] = "" + secretKey.charAt(i);
		}

		return secretArray;

	}
}
