package Bundesnachrichtendienst;



public class PreTest {

	
	
	public static void main(String[] args) throws CrypterException {
		CrypterFactory.CrypterType haha = CrypterFactory.CrypterType.CAESAR;
		CrypterFactory.CrypterType jojo = CrypterFactory.CrypterType.REVERSE;
		CrypterFactory.CrypterType bobo = CrypterFactory.CrypterType.SUBSTITUTION;
		CrypterFactory.CrypterType lolo = CrypterFactory.CrypterType.XOR;
		
		
		Crypter caesar = CrypterFactory.createCrypter("C", haha);
		System.out.println(caesar.encrypt("CAESAR"));
		System.out.println(caesar.decrypt("FDHVDU"));
		
		
		
		Crypter reverse = CrypterFactory.createCrypter("gagagaga", jojo);
		
		System.out.println(reverse.encrypt("ABCDEFG"));
		System.out.println(reverse.decrypt("GFEDCBA"));
		
														//	 ABCDEFGHIJKLMNOPQRSTUVWXYZ
		Crypter substitution = CrypterFactory.createCrypter("YZABCDEFGHIJKLMNOPQRSTUVWX", bobo);
		System.out.println(substitution.encrypt("MUSTAFA"));
		System.out.println(substitution.decrypt("YZABCP"));
		
		
		Crypter XOR = CrypterFactory.createCrypter("URFVW", lolo);
		
	
		String[] secretArray = new String[26];
		int j = 0;
		String key = "URFVW";
		
		// Füllt das Key Array
		while (j < 26) {
		
			// Durchläuft alle Buchstaben des Keys
			for(int i = 0; i < key.length(); i++){
				secretArray[j] = "" + key.charAt(i);
				j++;
				System.out.println(j);
			}
			
		}
			
		for (int i = 0; i < 26; i++){
			System.out.print(secretArray[i]);
		}
		 
		
	}		
	
}

