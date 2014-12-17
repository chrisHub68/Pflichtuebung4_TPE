package Bundesnachrichtendienst;

import java.util.*;

/**
 * Implemntiert das Interface Iterable zur entschlüsselung und erzeugung eines
 * Iterator
 * 
 * @author TPE Gruppe 14
 */
public class IterableDecrypter implements Iterable<String> {

    private List<String> list;

    /**
     * Konstruktor
     * 
     * @param list
     * @param crypter
     * @throws CrypterException
     */
    public IterableDecrypter(Iterable<String> list, Crypter crypter)
            throws CrypterException {
        // Direkt entschlüsseln
        this.list = crypter.decrypt(castIterableToList(list));
    }

    /**
     * Methode zum Umwandeln von Iterable<String> in List<String>
     * 
     * @param rawList
     * @return
     * @throws CrypterException
     */
    private List<String> castIterableToList(Iterable<String> rawList)
            throws CrypterException {

        List<String> theList = new ArrayList<String>();
        // Alle Elemente in neue Liste schreiben
        for (String string : rawList) {
            theList.add(string);
        }
        return theList;
    }

    /**
     * Methode zum erzeugen des Iterators
     * 
     * @return Iterator
     */
    @Override
    public Iterator<String> iterator() {
        // // Consumer zum Anwenden des Crypters auf alle Elemente der Liste
        // Consumer<String> action = (message) -> crypter.encrypt(message);
        // // Alle Elemente verschlüsseln
        // list.forEach(action);
        // return list.iterator();
        return list.iterator();
    }

}
