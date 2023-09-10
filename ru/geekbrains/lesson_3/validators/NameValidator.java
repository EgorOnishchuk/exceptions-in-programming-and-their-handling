package ru.geekbrains.lesson_3.validators;

import ru.geekbrains.lesson_3.InvalidDataException;

/**
 * Проверка имени на действительность.
 */
public class NameValidator implements ExceptionValidator {
    
    /**
     * Сообщение об ошибке.
     */
    private String message;

    public NameValidator(String message) {
        this.message = message;
    }

    /**
     * Проверяет имя на написание на английском языке и вызывает исключение,
     * если оно недействительно.
     */
    @Override
    public void validate(String name) throws InvalidDataException {
        if (name.matches("[a-zA-Z]*")) {
            return;
        }
        throw new InvalidDataException(message);
    }

}
