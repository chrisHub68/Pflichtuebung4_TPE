package Bundesnachrichtendienst;

import java.util.List;

public abstract class CrypterClass implements Crypter {
	
	// Schlüssel
	protected String key;
	
	public CrypterClass(String key) {
		this.key = key;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> decrypt(List<String> CypherMessages)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
