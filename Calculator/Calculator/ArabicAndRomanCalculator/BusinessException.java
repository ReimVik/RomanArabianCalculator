package ru.ArabicAndRomanCalculator;

public class BusinessException extends RuntimeException {
    private final String description;

    public BusinessException(String message, String description) {
        super(message);
        this.description = description;
    }

    public String description() {
        return description;
    }
}
