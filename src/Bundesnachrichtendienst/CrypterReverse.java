package Bundesnachrichtendienst;

import java.util.ArrayList;
import java.util.List;

class CrypterReverse extends CrypterClass{

	public CrypterReverse(String key) {
		super(key);
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		
		String reverseMessage = "";
		
		// Durchl‰uft den String r¸ckw‰rts und gibt ihn aus
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
			// F√ºge jeden verschl√ºsselten String der Liste hinzu
			encryptedMessages.add(encrypt(message));
		}

		return encryptedMessages;
		
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		String decryptedMessage = encrypt(cypherText);
		return decryptedMessage;
	}

	@Override
	public List<String> decrypt(List<String> CypherMessages) throws CrypterException {
		List<String> decryptedMessages = encrypt(CypherMessages);
		return decryptedMessages;
	}

	
	
}
