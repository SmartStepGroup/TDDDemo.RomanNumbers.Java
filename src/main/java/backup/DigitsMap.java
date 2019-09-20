package backup;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DigitsMap {
    private List<Pair<Integer, Character>> digitsMap = new ArrayList<>();

    public DigitsMap() {
        digitsMap.add(new Pair<>(1000, 'M'));
        digitsMap.add(new Pair<>(500, 'D'));
        digitsMap.add(new Pair<>(100, 'C'));
        digitsMap.add(new Pair<>(50, 'L'));
        digitsMap.add(new Pair<>(10, 'X'));
        digitsMap.add(new Pair<>(5, 'V'));
        digitsMap.add(new Pair<>(1, 'I'));
    }

    public List<Integer> getArabicDigits() {
        return digitsMap
                .stream()
                .map(Pair::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public Character getRomanDigits(int arabicDigit) {
        for (Pair<Integer, Character> pair : digitsMap) {
            if (pair.getKey() == arabicDigit) return pair.getValue();
        }
        throw new IllegalArgumentException();
    }


    public Character getNextRomanDigit(char romanDigit) {
        List<Character> romanDigits = digitsMap.stream().map(Pair::getValue).collect(Collectors.toList());
        int index = romanDigits.indexOf(romanDigit);
        return romanDigits.get(index - 1);
    }
}
