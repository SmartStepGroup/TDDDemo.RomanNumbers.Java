public class Digit {
    Integer arabic;
    Character roman;

    public Digit(Integer arabic, Character roman) {
        this.arabic = arabic;
        this.roman = roman;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Digit digit = (Digit) o;

        if (arabic != null ? !arabic.equals(digit.arabic) : digit.arabic != null) return false;
        return !(roman != null ? !roman.equals(digit.roman) : digit.roman != null);

    }

    @Override
    public int hashCode() {
        int result = arabic != null ? arabic.hashCode() : 0;
        result = 31 * result + (roman != null ? roman.hashCode() : 0);
        return result;
    }
}
