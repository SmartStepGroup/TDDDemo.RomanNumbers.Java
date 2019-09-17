package domain;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class DigitsMap2 {
    private List<Pair<Integer, Character>> digitsMap = new ArrayList<>();

    DigitsMap2() {
        digitsMap.add(new Pair<>(10, 'X'));
        digitsMap.add(new Pair<>(5, 'V'));
    }

    int size() {
        return digitsMap.size();
    }

    int arabicDigit(int index) {
        return digitsMap.get(index).getKey();
    }

    char romanDigit(int index) {
        return digitsMap.get(index).getValue();
    }
}
