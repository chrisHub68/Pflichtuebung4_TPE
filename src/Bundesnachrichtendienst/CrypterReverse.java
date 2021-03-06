package Bundesnachrichtendienst;

import java.util.ArrayList;
import java.util.List;
/**
 * CrypterReverse gibt das Inverse einer Nachricht aus.
 * Der Schlüssel ist für CrypterReverse irrelevant.
 */
class CrypterReverse extends CrypterClass{

	public CrypterReverse(String key) {
		super(key);
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		
		message = correctedMessage(message);
		String reverseMessage = "";
		
		// Durchläuft den String rückwärts und gibt ihn zurück
		for(int i=message.length()-1; i>=0; i--){
			reverseMessage += message.charAt(i);
		}
		
		return reverseMessage;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> encryptedMessages = new ArrayList<>();

		// Durchlaufe alle Strings
		for (String message : messages) {
			// Füge jeden verschlüsselten String der Liste hinzu
			encryptedMessages.add(encrypt(message));
		}

		return encryptedMessages;
		
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		
		cypherText = correctedMessage(cypherText);
		String decryptedMessage = encrypt(cypherText);
		return decryptedMessage;
	}

	@Override
	public List<String> decrypt(List<String> CypherMessages) throws CrypterException {
		List<String> decryptedMessages = encrypt(CypherMessages);
		return decryptedMessages;
	}

	
	
}
