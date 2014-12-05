package Bundesnachrichtendienst;



public class PreTest {

	
	
	public static void main(String[] args) throws CrypterException {
		CrypterFactory.CrypterType haha = CrypterFactory.CrypterType.CAESAR;
		CrypterFactory.CrypterType jojo = CrypterFactory.CrypterType.REVERSE;
		CrypterFactory.CrypterType bobo = CrypterFactory.CrypterType.SUBSTITUTION;
		
		
		Crypter caesar = CrypterFactory.createCrypter("C", haha);
		System.out.println(caesar.encrypt("CAESAR"));
		System.out.println(caesar.decrypt("FDHVDU"));
		
		
		
		Crypter reverse = CrypterFactory.createCrypter("gagagaga", jojo);
		
		System.out.println(reverse.encrypt("ABCDEFG"));
		System.out.println(reverse.decrypt("GFEDCBA"));
		
														//	 ABCDEFGHIJKLMNOPQRSTUVWXYZ
		Crypter substitution = CrypterFactory.createCrypter("YZABCDEFGHIJKLMNOPQRSTUVWX", bobo);
		System.out.println(substitution.encrypt("ABCDER"));
		System.out.println(substitution.decrypt("YZABCP"));
		
		
		
	}		
	}


