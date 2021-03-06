package Bundesnachrichtendienst;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementiert die Methoden zum verschlüsseln und entschlüsseln mit der
 * XOR-Verschlüsselung
 *
 */
class CrypterXOR extends CrypterClass {

    // Schlüssel Array
    private String[] secretKey;
    // ASCII Code von A bis ` (32 Zeichen)
    private String[] myASCII;

    public CrypterXOR(String key) throws IllegalKeyException {
        super(key);
        checkKey(key, (int) Math.pow(2, 32));
        this.myASCII = generateASCII('@', 32);

    }

    @Override
    public String encrypt(String message) throws CrypterException {

        this.secretKey = putSecretKey(key, message);
        message = correctedMessage(message);
        String encryptedMessage = "";

        // Durchläuft alle Buchstaben des Klartextes
        for (int i = 0; i < message.length(); i++) {

            // XOR Verknüpfung Key mit Klartext
            encryptedMessage += ""
                    + myASCII[secretKey[i].charAt(0) ^ message.charAt(i)];

        }

        return encryptedMessage;
    }

    @Override
    public List<String> encrypt(List<String> messages) throws CrypterException {
        List<String> encryptedMessages = new ArrayList<>();

        for (String message : messages) {
            // Füge jeden verschlüsselten String der Liste hinzu
            encryptedMessages.add(encrypt(message));
        }

        return encryptedMessages;
    }

    @Override
    public String decrypt(String cypherText) throws CrypterException {

        this.secretKey = putSecretKey(key, cypherText);
        cypherText = cypherText.toUpperCase();
        String decryptedMessage = "";

        // Durchläuft alle Buchstaben des Klartextes
        for (int i = 0; i < cypherText.length(); i++) {

            // XOR Verknüpfung Key mit Klartext
            decryptedMessage += ""
                    + myASCII[secretKey[i].charAt(0) ^ cypherText.charAt(i)];

        }

        return decryptedMessage;
    }

    @Override
    public List<String> decrypt(List<String> cypherTexte)
            throws CrypterException {
        List<String> decryptedMessages = new ArrayList<>();

        for (String message : cypherTexte) {
            // Füge jeden entschlüsselten String der Liste hinzu
            decryptedMessages.add(encrypt(message));
        }

        return decryptedMessages;
    }

    // generiert ein Array mit einer Zeichenfolge aus der ASCII Tabelle
    private String[] generateASCII(char start, int length) {

        String[] asciiCode = new String[length];
        char letter = start;
        // Alle ASCII Zeichen in an Tabelle anhängen
        for (int i = 0; i < length; i++, letter++) {
            asciiCode[i] = "" + letter;
        }

        return asciiCode;
    }

    // schreibt den Schlüssel in ein Array
    private String[] putSecretKey(String key, String message) {

        String[] secretArray = new String[100];
        String[] temp = new String[100];
        int j = 0;

        // Schreibt den Schlüssel in ein Array bis zur Länge 26
        // Falls notwendig wird der Schlüssel wiederholt wenn key < 26
        while (j < message.length()) {

            // Durchläuft alle Buchstaben des Keys
            for (int i = 0; i < key.length(); i++) {
                temp[j] = "" + key.charAt(i);
                j++;
            }

        }
        // Ãœbertrage die ersten 26 Buchstaben aus dem Key in das SecretArray
        for (int i = 0; i < message.length(); i++) {
            secretArray[i] = temp[i];
        }

        return secretArray;
    }

}
