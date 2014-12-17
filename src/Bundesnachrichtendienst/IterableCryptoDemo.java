package Bundesnachrichtendienst;

import java.util.Arrays;
import java.util.List;



public class IterableCryptoDemo {

    public static void main(String[] args) throws CrypterException {
        CrypterFactory.CrypterType verschlüsselungsartCaesar = CrypterFactory.CrypterType.CAESAR;
        CrypterFactory.CrypterType verschlüsselungsartXOR = CrypterFactory.CrypterType.XOR;

        Crypter caesar = CrypterFactory.createCrypter("U",
                verschlüsselungsartCaesar);
        Crypter xor = CrypterFactory.createCrypter("TPEISTCOOL",
                verschlüsselungsartXOR);
        List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");

        IterableCrypter iterableCrypter = new IterableCrypter(
                new IterableCrypter(liste, caesar), caesar);

        for (String cypherText : iterableCrypter) {
            System.out.println(cypherText);
        }

    }

}
