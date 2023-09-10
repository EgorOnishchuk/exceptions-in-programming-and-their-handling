package ru.geekbrains.lesson_3.validators;

import ru.geekbrains.lesson_3.InvalidDataException;

/**
 * Проверка даты рождения на действительность.
 */
public class BirthDateValidator implements ExceptionValidator {
    
    /**
     * Сообщение об ошибке.
     */
    private String message;

    public BirthDateValidator(String message) {
        this.message = message;
    }

    /**
     * Проверяет дату рождения на действительность и вызывает исключение,
     * если она не соответствует формату "ДД.ММ.ГГГГ".
     */
    public void validate(String birthDate) throws InvalidDataException {
        if (birthDate.matches("\\d{2}.\\d{2}.\\d{4}")) {
            return;
        }
        throw new InvalidDataException(message);
    }

}
