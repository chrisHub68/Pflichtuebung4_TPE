package Bundesnachrichtendienst;

import java.util.Iterator;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class CrypterFactory {

	enum CrypterType {
		// Verschlüsselungsimplementierungen
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL;
	}

	public static Crypter createCrypter(String key, CrypterType crypter) throws IllegalKeyException{

		// Konvertiert jeden Kleinbuchstaben des Schlüssels in seinen entsprechenden Großbuchstaben
		key = key.toUpperCase();
		
		// Prüfe Gültigkeit des Schlüssels
		checkKey(key);
		
		
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
	
	// Prüft jeden einzelnen Buchstaben im Schlüssel ob er zwischen @ und _ liegt
	// Wirft eine Exception wenn Schlüssel ungültig
	public static void checkKey(String key) throws IllegalKeyException{
		for(int i=0; i<key.length() ; i++){
			if(key.charAt(i) < '@' || key.charAt(i) > '_'){
				throw new IllegalKeyException();
			}
			
		}
	}
}
