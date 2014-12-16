package Bundesnachrichtendienst;

import java.util.ArrayList;
import java.util.List;

class CrypterXOR extends CrypterClass {

	// Schlï¿½ssel Array
	String[] secretKey;
	// Alphabet Array
	String[] plainText;
	// ASCII Code von A bis ` (32 Zeichen)
	String[] myASCII;

	
	public CrypterXOR(String key) throws IllegalKeyException {
		super(key);
		checkKey(key, (int) Math.pow(2, 32));
		this.secretKey = putSecretKey(key);
		this.plainText = generateASCII('A', 26);
		this.myASCII = generateASCII('@', 32);

	}

	@Override
	public String encrypt(String message) throws CrypterException {

		message = correctedMessage(message);
		String encryptedMessage = "";

		// VerschlÃ¼sselt jeden einzelnen Buchstaben der Eingabe
		for (int i = 0; i < message.length(); i++) {

			encryptedMessage += ""
					+ myASCII[secretKey[i].charAt(0) ^ message.charAt(i)];
		}
		return encryptedMessage;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> encryptedMessages = new ArrayList<>();

		for (String message : messages) {
			// Füge jeden verschlüsselten String der Liste hinzu
			encryptedMessages.add(encrypt(message));
		}

		return encryptedMessages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

		// XOR ist symmetrisch, also ist Entschlüsselung nur die Umkehrung von
		// Verschlüsselung
		return encrypt(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return super.decrypt(cypherTexte);
	}

	// generiert ein Array mit einer Zeichenfolge aus der ASCII Tabelle
	private String[] generateASCII(char start, int length) {

		String[] asciiCode = new String[length];
		char letter = start;

		for (int i = 0; i < length; i++, letter++) {
			asciiCode[i] = "" + letter;
		}

		return asciiCode;
	}

	// schreibt den Schlüssel in ein Array
	private String[] putSecretKey(String key) {

		String[] secretArray = new String[26];
		String[] temp = new String[50];
		int j = 0;

		// Schreibt den Schlüssel in ein Array bis zur Länge 26
		// Falls notwendig wird der Schlüssel wiederholt wenn key < 26
		while (j < 26) {

			// DurchlÃ¤uft alle Buchstaben des Keys
			for (int i = 0; i < key.length(); i++) {
				temp[j] = "" + key.charAt(i);
				j++;
			}

		}
		// Ãœbertrage die ersten 26 Buchstaben aus dem Key in das SecretArray
		for (int i = 0; i < 26; i++) {
			secretArray[i] = temp[i];
		}

		return secretArray;
	}

}
