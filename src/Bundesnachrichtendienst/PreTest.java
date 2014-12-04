package Bundesnachrichtendienst;



public class PreTest {

	
	
	public static void main(String[] args) throws CrypterException {
		CrypterFactory.CrypterType haha = CrypterFactory.CrypterType.CAESAR;
		
		Crypter caesar = CrypterFactory.createCrypter("C", haha);

		
		System.out.println(caesar.encrypt("CAESAR"));
		System.out.println(caesar.decrypt("FDHVDU"));
		
	}

}
