package Bundesnachrichtendienst;

import java.util.List;

/**
 * Grundlegendes Interface, um Verschlüsselung durchzuführen. Mit Hilfe dieses
 * Interfaces kann man Nachrichten verschlüsseln (über die
 * {@link #encrypt(String)} Methode) und wieder entschlüsseln (über die
 * {@link #decrypt(String)} Methode).
 *
 * Der Eingabetext ({@literal message}) darf nur aus den Groß-Buchstaben A-Z
 * bestehen. Kleinbuchstaben werden in Großbuchstaben umgewandelt, alle anderen
 * Zeichen werden ohne Rückmeldung entfernt (einschließlich der Leerzeichen).
 *
 * Zwischen den beiden Methoden muss bei gleichem Schlüssel {@code key}
 * folgendes gelten: {@code text.equals(decrypt(encrypt(text)) == true}.
 *
 * @author Thomas Smits
 */
public interface Crypter {
    /**
     * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param message
     *            Nachricht, die Verschlüsselt werden soll.
     *
     * @return verschlüsselter Text.
     * @throws CrypterException
     *             Wird geworfen, wenn Probleme mit der Verschlüsselung
     *             auftreten.
     */
    public String encrypt(String message) throws CrypterException;

    /**
     * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param messages
     *            Nachrichten, die Verschlüsselt werden soll.
     *
     * @return verschlüsselte Texte.
     * @throws CrypterException
     *             Wird geworfen, wenn Probleme mit der Verschlüsselung
     *             auftreten.
     */
    public List<String> encrypt(List<String> messages) throws CrypterException;

    /**
     * Entschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param cypherText
     *            Nachricht, die entschlüsselt werden soll.
     *
     * @return entschlüsselter Text.
     * @throws CrypterException
     *             Wird geworfen, wenn Probleme mit der Verschlüsselung
     *             auftreten.
     */
    public String decrypt(String cypherText) throws CrypterException;

    /**
     * Entschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
     *
     * @param CypherMessages
     *            Nachrichten, die entschlüsselt werden soll.
     *
     * @return entschlüsselte Texte.
     * @throws CrypterException
     *             Wird geworfen, wenn Probleme mit der Verschlüsselung
     *             auftreten.
     */
    public List<String> decrypt(List<String> CypherMessages)
            throws CrypterException;
}