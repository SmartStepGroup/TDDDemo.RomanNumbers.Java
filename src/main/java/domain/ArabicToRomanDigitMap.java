package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArabicToRomanDigitMap implements Iterable<Digit> {
    private ArrayList<Digit> map;

    public ArabicToRomanDigitMap() {
        map = new ArrayList<>();
        map.add(new Digit(1000, 'M'));
        map.add(new Digit(500, 'D'));
        map.add(new Digit(100, 'C'));
        map.add(new Digit(50, 'L'));
        map.add(new Digit(10, 'X'));
        map.add(new Digit(5, 'V'));
        map.add(new Digit(1, 'I'));
    }

    public Character getNextRomanNumber(Character romanNumber) {
        return map.get(getIndex(romanNumber) - 1).roman;
    }

    private int getIndex(Character romanNumber) {
        int index = 0;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).roman == romanNumber) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public Iterator<Digit> iterator() {
        return map.iterator();
    }

    @Override
    public void forEach(Consumer<? super Digit> action) {
        map.forEach(action);
    }

    @Override
    public Spliterator<Digit> spliterator() {
        return map.spliterator();
    }
}
