import java.util.Scanner;
public class Main {
    public String getTokens(int i) {
        return tokens[i];
    }
    static  String input;
    String[] tokens;
    int i;
    void tokens (String input) {
        this.tokens = input.split(" ");
        this.i = 0;
    }
    int calculate(int first_number, int second_number) {
        if ((first_number<1||first_number>10) || (second_number<1||second_number>10))
        {
            throw new IllegalArgumentException("Числа должны быть только от 1 до 10");
        }
        if (tokens.length>3) {
            throw new IllegalArgumentException(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        i++;
        while (i < tokens.length) {
            String operator = tokens[i];
            if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && operator.equals("/")) {
                break;
            } else {
                i++;
            }
            switch (operator) {
                case "-":
                    first_number -= second_number;
                    break;
                case "+":
                    first_number += second_number;
                    break;
                case "/":
                    first_number /= second_number;
                    break;
                case "*":
                    first_number *= second_number;
                    break;
            }
        }
        return first_number;
    }
    public static void main(String[] args) {
        Main calculator = new Main();
        Scanner s = new Scanner(System.in);
        input = s.nextLine();
        RomanNumbers num1 = new RomanNumbers();
        RomanNumbers num2 = new RomanNumbers();
        calculator.tokens (input);
        if ( num1.isRoman(calculator.getTokens(0))) {
            if (num2.isRoman(calculator.getTokens(2))) {
                int itog = calculator.calculate(num1.getNumber(),num2.getNumber());
                if (itog < 0) {
                    throw new IllegalArgumentException("в римской системе нет отрицательных чисел");
                }
                System.out.println(num1.arabicToRoman(itog));
            }
            else {
                throw new IllegalArgumentException("используются одновременно разные системы счисления");
            }

        }
        else if (num2.isRoman(calculator.getTokens(2))) {
            if (num1.isRoman(calculator.getTokens(0))) {
                int itog = calculator.calculate(num1.getNumber(),num2.getNumber());
                if (itog < 0) {
                    throw new IllegalArgumentException("в римской системе нет отрицательных чисел");
                }
                System.out.println(num1.arabicToRoman(itog));
            }
            else {
                throw new IllegalArgumentException("используются одновременно разные системы счисления");
            }
        }
        else {
            int itog2 = calculator.calculate(Integer.parseInt(calculator.getTokens(0)),Integer.parseInt(calculator.getTokens(2)));
            System.out.println(itog2);
        }
    }
}