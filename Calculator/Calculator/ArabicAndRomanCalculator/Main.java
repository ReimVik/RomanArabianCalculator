package ru.ArabicAndRomanCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String calculator = getString();

        //2+2 проверить
        //   calculator.matches("^\\d{1,2}[ ][\\+\\-\\*\\/][ ]\\d{1,2}$");
        if (calculator.matches("^\\d{1,2}[ ][\\+\\-\\*\\/][ ]\\d{1,2}$")) {//арабские цифры
            ArabicCalculator arabicCalculator = new ArabicCalculator();
            try {
                arabicCalculator.calculate(calculator);
            } catch (BusinessException e) {
                System.out.printf("Ошибка '%s', причина '%s'", e.getMessage(), e.description());
            }
        } else if (calculator.matches("^[IVX]{1,4}[ ][\\+\\-\\*\\/][ ][IVX]{1,4}$")) { // римские цифры
            System.out.println("Римский пример");
            Calculator calculatorVI = new RomanCalculator();
            try {
                calculatorVI.calculate(calculator);
            }
            catch (BusinessException e) {
                System.out.printf("Ошибка '%s', причина '%s'", e.getMessage(), e.description());
            }
        } else {
            System.out.println("Неправильно ввели");
        }


    }

    private static String getString() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();

    }

}
