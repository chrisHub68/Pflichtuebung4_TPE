package junit_Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Bundesnachrichtendienst.Crypter;
import Bundesnachrichtendienst.CrypterException;
import Bundesnachrichtendienst.CrypterFactory;
import Bundesnachrichtendienst.IllegalKeyException;

public class CrypterTest {

    @Test
    public void test() throws CrypterException {
        //Entschlüsseln der Geheimen Botschaft
        
        //Crypter Anlegen 
        CrypterFactory.CrypterType caesar = CrypterFactory.CrypterType.CAESAR;
        CrypterFactory.CrypterType reverse = CrypterFactory.CrypterType.REVERSE;
        CrypterFactory.CrypterType substitution = CrypterFactory.CrypterType.SUBSTITUTION;
        CrypterFactory.CrypterType xor = CrypterFactory.CrypterType.XOR;
        CrypterFactory.CrypterType nul = CrypterFactory.CrypterType.NULL;

        //Entschlüsselungsarten 
        Crypter substitutionCrypter = CrypterFactory.createCrypter("UFLPWDRASJMCONQYBVTEXHZKGI", substitution);
        Crypter caesarCrypter = CrypterFactory.createCrypter("Y", caesar);
        Crypter reverseCrypter = CrypterFactory.createCrypter("hallo" , reverse);
        Crypter xorCrypter = CrypterFactory.createCrypter("TPERULESTPERULESTPERULESTP",xor);
        Crypter nulCrypter  = CrypterFactory.createCrypter("hallo", nul);
        
        //Teststring    
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        //Test der Nullchiffre
        assertEquals(alphabet, nulCrypter.encrypt(alphabet));
        assertEquals(alphabet, nulCrypter.decrypt(alphabet));
        
        //Test der Caesar-Verschlüsselung
        //Verschoben um 25 Zeichen 
        assertEquals("ZABCDEFGHIJKLMNOPQRSTUVWXY", caesarCrypter.encrypt(alphabet));
        assertEquals(alphabet, caesarCrypter.decrypt("ZABCDEFGHIJKLMNOPQRSTUVWXY"));
        
        //Test der Reverse Verschlüsselung 
        assertEquals("ZYXWVUTSRQPONMLKJIHGFEDCBA", reverseCrypter.encrypt(alphabet));
        assertEquals(alphabet,reverseCrypter.decrypt("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
        
        //Test der XOR-Verschlüsselung 
        assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ" , xorCrypter.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals( "ABCDEFGHIJKLMNOPQRSTUVWXYZ", xorCrypter.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
        
        
        //Test der Substitutionchiffre
        assertEquals("ZSMSYWPSUSTESNDQVOUESH" , substitutionCrypter.encrypt("WIKIPEDIAISTINFORMATIV"));
        assertEquals("WIKIPEDIAISTINFORMATIV" , substitutionCrypter.decrypt("ZSMSYWPSUSTESNDQVOUESH"));
        
    }

}
