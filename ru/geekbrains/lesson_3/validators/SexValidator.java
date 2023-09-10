package ru.geekbrains.lesson_3.validators;

import ru.geekbrains.lesson_3.InvalidDataException;

/**
 * Проверка пола на действительность.
 */
public class SexValidator implements ExceptionValidator {
    
    /**
     * Сообщение об ошибке.
     */
    private String message;

    public SexValidator(String message) {
        this.message = message;
    }

    /**
     * Проверяет пол на действительность и вызывает исключение, если он
     * недействителен.
     */
    public void validate(String sex) throws InvalidDataException {
        if (sex.equals("m") || sex.equals("f")) {
            return;
        }
        throw new InvalidDataException(message);
    }

}
