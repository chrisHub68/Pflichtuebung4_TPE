package Bundesnachrichtendienst;



public class PreTest {

	
	
	public static void main(String[] args) throws CrypterException {
		CrypterFactory.CrypterType haha = CrypterFactory.CrypterType.CAESAR;
		CrypterFactory.CrypterType jojo = CrypterFactory.CrypterType.REVERSE;
		CrypterFactory.CrypterType bobo = CrypterFactory.CrypterType.SUBSTITUTION;
		CrypterFactory.CrypterType lolo = CrypterFactory.CrypterType.XOR;

		
		/*
		Crypter caesar = CrypterFactory.createCrypter("C", haha);
		
		System.out.println(caesar.encrypt("caesar__") + " ");
		//System.out.println(caesar.decrypt("FDHVDU"));
		
		
		
		Crypter reverse = CrypterFactory.createCrypter("gagagaga", jojo);
		
		System.out.println(reverse.encrypt("ABCDEFG"));
		System.out.println(reverse.decrypt("GFEDCBA"));
		
														//	 ABCDEFGHIJKLMNOPQRSTUVWXYZ
		Crypter substitution = CrypterFactory.createCrypter("YZABCDEFGHIJKLMNOPQRSTUVWX", bobo);
		System.out.println(substitution.encrypt("MUSTAFA"));
		System.out.println(substitution.decrypt("YZABCP"));
		
		*/
		Crypter XOR = CrypterFactory.createCrypter("ABCDEFGHIJKLMNOPQRSTUVWXYZ", lolo);

		
		System.out.println(XOR.encrypt("HALLO"));
		System.out.println(XOR.decrypt("ICOHJ"));
		
	
	
		
	}		
	
}

