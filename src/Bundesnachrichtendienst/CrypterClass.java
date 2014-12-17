package Bundesnachrichtendienst;

import java.util.List;

/**
 * CrypterClass ist eine abstrakte Oberklasse von allen Verschlüsselungsklassen
 *
 */
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

    @Override
    public void checkKey(String key, int length) throws IllegalKeyException {

        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) < 'A' || key.charAt(i) > 'Z'
                    || key.length() > length) {
                throw new IllegalKeyException();
            }

        }
    }

    @Override
    public String correctedMessage(String message) {
        String correctedMessage = "";

        message = message.toUpperCase();

        // Schreibt nur die Zeichen der Message in den neuen String, die den
        // Zeichen von
        // A bis Z entsprechen.
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {
                correctedMessage += "" + message.charAt(i);
            }
        }

        return correctedMessage;
    }

}
