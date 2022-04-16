package ru.ArabicAndRomanCalculator;

//import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.TreeMap;

public class RomanCalculator implements Calculator {

    private final Map<String, Integer> romanMap = Map.of(
            "I", 1,
            "II", 2,
            "III", 3,
            "IV", 4,
            "V", 5,
            "VI", 6,
            "VII", 7,
            "VIII", 8,
            "IX", 9,
            "X", 10

    );

    private final TreeMap<Integer, String> romanToArabic = new TreeMap<>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
    }};

    @Override
    public void calculate(String expression) {
        int operand1 = romanMap.getOrDefault(expression.split(" ")[0], 0);
        int operand2 = romanMap.getOrDefault(expression.split(" ")[2], 0);

        if (operand1 == 0 || operand2 == 0) {
            throw new BusinessException("Ошибка вычисления", "операнд не входит в диапазон допустимых значений");
        }

        switch (expression.split(" ")[1]) {
            case "+":
                addition(operand1, operand2);
                break;
            case "-":
                subtraction(operand1, operand2);
                break;
            case "*":
                multiplication(operand1, operand2);
                break;
            case "/":
                division(operand1, operand2);
                break;

        }
    }

    private void addition(int operand1, int operand2) {

        System.out.println(convertToRoman(operand1 + operand2));
    }

    private void subtraction(int operand1, int operand2) {
        if (operand1 == operand2) {
            throw new BusinessException("Ошибка вычисления", "Операнды не могут быть равны");
        }
        if (operand1 < operand2) {
            throw new BusinessException("Ошибка вычисления", "Второй операнд не может быть больше первого");
        }
        System.out.println(convertToRoman(operand1 - operand2));
    }

    private void multiplication(int operand1, int operand2) {
        System.out.println(convertToRoman(operand1 * operand2));
    }

    private void division(int operand1, int operand2) {
        if (operand1 % operand2 != 0) {
            throw new BusinessException("Ошибка вычисления", "При делении присутствует дробная часть");
        }
        System.out.println(convertToRoman(operand1 / operand2));
    }

    private String convertToRoman(int number) {
        int x = romanToArabic.floorKey(number);

        return number == x ?
                romanToArabic.get(number) :
                romanToArabic.get(x) + convertToRoman(number - x);
    }
    

}
