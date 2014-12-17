package Bundesnachrichtendienst;

import java.util.List;
/**
 * CrypterNull macht nichts, d.h. die Nachricht wird so ausgegeben wie sie
 * eingegeben wurde. Der Schlüssel ist für CrypterNull irrelevant.
 * 
 */
class CrypterNull extends CrypterClass {

	public CrypterNull(String key) {
		super(key);
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		message = correctedMessage(message);
		return message;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		return messages;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		cypherText = correctedMessage(cypherText);
		return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> CypherMessages) throws CrypterException {
		return CypherMessages;
	}
	
	

}
