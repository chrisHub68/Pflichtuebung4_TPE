package Bundesnachrichtendienst;

import java.util.List;

class CrypterSubstitution extends CrypterClass {

	// Schlüssel
	String[] secretKey;
	// Alphabet
	String[] alphabet;

	public CrypterSubstitution(String key) {
		super(key);
		this.secretKey = secretKey(key);
		this.alphabet = alphabetArray();
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		String encryptedMessage = "";

		// Durchläuft den String und vertauscht jeden Buchstaben gemäß seiner
		// Postition im Schlüssel
		for (int i = 0; i < message.length(); i++) {
			encryptedMessage += secretKey[message.charAt(i) - 65];
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
	private String[] alphabetArray() {

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
		for (int i = 0; i < 26; i++) {
			secretArray[i] = "" + secretKey.charAt(i);
		}

		return secretArray;

	}
}
