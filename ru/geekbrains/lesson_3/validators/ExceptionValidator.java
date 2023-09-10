package ru.geekbrains.lesson_3.validators;

import ru.geekbrains.lesson_3.InvalidDataException;

/**
 * Проверка значения на действительность.
 */
public interface ExceptionValidator {
    
    /**
     * Проверяет значения на действительность и вызывает исключение, если оно
     * недействительно.
     */
    void validate(String string) throws InvalidDataException;

}
