package ru.geekbrains.lesson_3.validators;

import ru.geekbrains.lesson_3.InvalidDataException;

/**
 * Проверка номера телефона на действительность.
 */
public class PhoneNumValidator implements ExceptionValidator {
    
    /**
     * Сообщение об ошибке.
     */
    private String message;

    public PhoneNumValidator(String message) {
        this.message = message;
    }

    /**
     * Проверяет наличие в номере телефона только цифр и вызывает исключение,
     * если он недействителен.
     */
    public void validate(String phoneNum) throws InvalidDataException {
        if (phoneNum.matches("\\d{11}")) {
            return;
        }
        throw new InvalidDataException(message);
    }

}
