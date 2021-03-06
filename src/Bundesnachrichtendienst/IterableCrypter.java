package Bundesnachrichtendienst;

import java.util.*;
/**
 * 
 * @author 
 *
 */
public class IterableCrypter implements Iterable<String> {
    
    private List<String> list;

    /**
     * Konstruktor
     * @param list
     * @param crypter
     * @throws CrypterException
     */
    public IterableCrypter(Iterable<String> list, Crypter crypter)
            throws CrypterException {
        //Direkt verschlüsseln 
        this.list = crypter.encrypt(castIterableToList(list));
    }
    /**
     * @param rawList
     * @return
     * @throws CrypterException
     */
    private List<String> castIterableToList(Iterable<String> rawList)
            throws CrypterException {

        List<String> theList = new ArrayList<String>();
        //Alle Element in die Neue Liste schreiben
        for (String string : rawList) {
            theList.add(string);
        }
        return theList;
    }
    /**
     * Methode zum erzeugen des Iterators 
     * @return Iterator
     */
    @Override
    public Iterator<String> iterator() {
        // // Consumer zum Anwenden des Crypters auf alle Elemente der Liste
        // Consumer<String> action = (message) -> crypter.encrypt(message);
        // // Alle Elemente verschlüsseln
        // list.forEach(action);
        // return list.iterator();
        return list.listIterator();
    }

}
