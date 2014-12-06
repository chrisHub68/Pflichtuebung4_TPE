package Bundesnachrichtendienst;

import java.util.ArrayList;
import java.util.List;

class CrypterXOR extends CrypterClass {

	// Schlï¿½ssel Array
	String[] secretKey;
	// Alphabet Array
	String[] plainText;
	// ASCII Code von A bis 32. Zeichen
	String[] myASCII;
	
	
	public CrypterXOR(String key) {
		super(key);
		this.secretKey = putSecretKey(key);
		this.plainText = generateASCII(26);
		this.myASCII = generateASCII(32);

	}

	@Override
	public String encrypt(String message) throws CrypterException {
		System.out.println();
		
		String encryptedMessage = "";

		// VerschlÃ¼sselt jeden einzelnen Buchstaben der Eingabe
		for (int i = 0; i < message.length(); i++) {
			// Sucht Buchstaben und seinen Index im Alphabet
			for (int j = 0; j < 26; j++) {
				if (message.charAt(i) == plainText[j].charAt(0)) {
					encryptedMessage += "" + xorChar(j); // //
				}
			}

		}
		System.out.println();
		return encryptedMessage;
	}

	// VerschlÃ¼sselt ein Zeichen mit XOR
	private char xorChar(int index) {
		
		char cryptedChar;
		// Wert des Zeichens an der Indexstelle im SchlüsselArray
		char plainIndex = secretKey[index].charAt(0);
		// Wert des Buchstabens an der Indexstelle im Alphabet
		char keyIndex = plainText[index].charAt(0);
		//XOR Verknüpfung
		cryptedChar = myASCII[(keyIndex ^ plainIndex)-1].charAt(0);

		return cryptedChar;
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
		// TODO Auto-generated method stub
		return super.decrypt(cypherText);
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return super.decrypt(cypherTexte);
	}

	private String[] generateASCII(int length) {

		String[] asciiCode = new String[length];
		char letter = 'A';

		for (int i = 0; i < length; i++, letter++) {
			asciiCode[i] = "" + letter;
			
			System.out.print(asciiCode[i]);
			//System.out.print(asciiCode[i]);
		}
System.out.println();
		return asciiCode;
	}


	
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
