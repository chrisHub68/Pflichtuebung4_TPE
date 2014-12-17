package junit_Tests;

import Bundesnachrichtendienst.Crypter;
import Bundesnachrichtendienst.CrypterFactory;

public class SecretMessage {

    public static void main(String[] args) {
        //Entschlüsseln der Geheimen Botschaft
        
        //Crypter Anlegen 
        CrypterFactory.CrypterType caesar = CrypterFactory.CrypterType.CAESAR;
        CrypterFactory.CrypterType reverse = CrypterFactory.CrypterType.REVERSE;
        CrypterFactory.CrypterType substitution = CrypterFactory.CrypterType.SUBSTITUTION;
        CrypterFactory.CrypterType xor = CrypterFactory.CrypterType.XOR;
        CrypterFactory.CrypterType nul = CrypterFactory.CrypterType.NULL;
        //"geheime Botschaft" von Aufgabenblatt
        char backslash = '\\';
        String secretMessage = "QOZEG]A[UXDKZIZLAB"+backslash+"NUQIO^^RXYHADV[EFFJ" + backslash+backslash+ "["+backslash+"U_]YDVZABDZT"
        +backslash+"V"+backslash+"SKB@X";
        System.out.println(secretMessage);
        //Entschlüsselungsarten 
        Crypter substitutionCrypter = CrypterFactory.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", substitution);
        Crypter caesarCrypter = CrypterFactory.createCrypter("L", caesar);
        Crypter reverseCrypter = CrypterFactory.createCrypter(reverse);
        Crypter xorCrypter = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS",xor);
        //Entschlüsselung
        secretMessage = xorCrypter.encrypt(secretMessage);
        secretMessage = substitutionCrypter.encrypt(secretMessage);
        secretMessage = caesarCrypter.encrypt(secretMessage);
        secretMessage = reverseCrypter.encrypt(secretMessage);
        

        System.out.println(secretMessage);
    }
}
