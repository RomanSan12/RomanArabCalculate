import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class RomanNumbers {
    private int number;
    public String arabicToRoman(int number) {
        List<RomanNumbersEnum> romanNumerals = RomanNumbersEnum.getReverseSortedValues();
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumbersEnum currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
    boolean isRoman(String Numbers) {
        String romanNumeral = Numbers.toUpperCase();
        int result = 0;

        List<RomanNumbersEnum> romanNumerals = RomanNumbersEnum.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumbersEnum symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanNumeral.length() > 0) {
            return false;
        }
        this.number = result;
        return true;
    }
    public int getNumber() {
        return number;
    }
    public enum RomanNumbersEnum {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);
        private int value;

        RomanNumbersEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


        public static List<RomanNumbersEnum> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumbersEnum e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }
}