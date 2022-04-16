package ru.ArabicAndRomanCalculator;

public class ArabicCalculator implements Calculator {
    @Override
    public void calculate(String expression) {
        int operand1 = Integer.parseInt(expression.split(" ")[0]);
        int operand2 = Integer.parseInt(expression.split(" ")[2]);

        if (operand1 < 0 || operand1 > 10) {
            throw new BusinessException("Ошибка вычисления", "Первый операнд не входит в диапазон допустимых значений");
        }
        if (operand2 < 0 || operand2 > 10) {
            throw new BusinessException("Ошибка вычисления", "Второй операнд не входит в диапазон допустимых значений");
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

        System.out.println(operand1 + operand2);
    }

    private void subtraction(int operand1, int operand2) {
        System.out.println(operand1 - operand2);
    }

    private void multiplication(int operand1, int operand2) {
        System.out.println(operand1 * operand2);
    }

    private void division(int operand1, int operand2) {
        System.out.println(operand1 / operand2);
    }


}
