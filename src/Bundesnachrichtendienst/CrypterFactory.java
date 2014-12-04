package Bundesnachrichtendienst;

public class CrypterFactory {

	enum CrypterType {
		// Verschlüsselungsimplementierungen
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL;
	}

	public static Crypter createCrypter(String key, CrypterType crypter) {

		switch (crypter) {

		case CAESAR:
			return new CrypterCaesar(key);
		case SUBSTITUTION:
			return new CrypterSubstitution(key);
		case REVERSE:
			return new CrypterReverse(key);
		case XOR:
			return new CrypterXOR(key);
		case NULL:
			return new CrypterNull(key);
		default: 
			return null;
		}
	}
}
