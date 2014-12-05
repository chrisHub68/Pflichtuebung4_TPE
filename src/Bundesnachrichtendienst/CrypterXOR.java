package Bundesnachrichtendienst;

import java.util.List;

class CrypterXOR extends CrypterClass {

	// Schl�ssel
	String[] secretKey;
	// Alphabet
	String[] plainText;

	public CrypterXOR(String key) {
		super(key);
		this.secretKey = putSecretKey(key);
		this.plainText = alphabetArray();
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		String encryptedMessage = "";

		// Verschlüsselt jeden einzelnen Buchstaben der Eingabe
		for (int i = 0; i < message.length(); i++) {
			// Sucht Buchstaben und seinen Index im Alphabet
			for (int j = 0; j < 26; j++) {
				if (message.charAt(i) == plainText[j].charAt(0)) {
					encryptedMessage += "" + xorChar(j);     ////
				}
			}

		}
		return encryptedMessage;
	}
	
	// Verschlüsselt ein Zeichen mit XOR
	private char xorChar(int plainPosition){
		char keyValue;
		char plainValue = plainText[plainPosition].charAt(0);
		char cryptedChar;
		int i = 0;
		
		// Zählt im Schlüssel bis zur entsprechenden Position hoch
		while(i < plainPosition){
			i++;
		}
	
		keyValue = secretKey[i].charAt(0);
		cryptedChar = (char) (plainValue ^ keyValue);
		
		return cryptedChar;
	}
	
	
 

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return super.encrypt(messages);
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return super.decrypt(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return super.decrypt(cypherTexte);
	}

	private String[] alphabetArray() {

		String[] alphabet = new String[26];
		char letter = 'A';

		for (int i = 0; i < 26; i++, letter++) {
			alphabet[i] = "" + letter;
		}

		return alphabet;
	}

	private String[] putSecretKey(String key) {

		String[] secretArray = new String[26];
		String[] temp = new String[key.length()];
		int j = 0;

		// Füllt das Key Array
		while (j < 26) {

			// Durchläuft alle Buchstaben des Keys
			for (int i = 0; i < key.length(); i++) {
				temp[j] = "" + key.charAt(i);
				j++;
			}

		}
		// Übertrage die ersten 26 Buchstaben aus dem Key in das SecretArray
		for (int i = 0; i < 26; i++) {
			secretArray[i] = temp[i];
		}
		return secretArray;
	}

}
