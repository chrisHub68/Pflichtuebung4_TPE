package Bundesnachrichtendienst;

import java.util.List;

class CrypterSubstitution extends CrypterClass {

	// Schl�ssel
	String[] secretKey;
	// Alphabet
	String[] alphabet;

	public CrypterSubstitution(String key) throws IllegalKeyException {
		super(key);
		checkKey(key, 26);
		this.secretKey = secretKey(key);
		this.alphabet = alphabetArray();
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		String encryptedMessage = "";

		// Durchl�uft den String und vertauscht jeden Buchstaben gem�� seiner
		// Postition im Schl�ssel
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

		// Durchl�uft den String und vertauscht jeden Buchstaben gem�� seiner
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
	 * Gibt ein String Array zur�ck, dass das Alphabet enth�lt
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
	 * Gibt ein String Array zur�ck, dass einen Schl�ssel f�r die
	 * Substitutionsverschl�sselung enth�lt
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
