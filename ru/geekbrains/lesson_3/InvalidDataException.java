package ru.geekbrains.lesson_3;

/**
 * Исключение, вызываемое при несоответствии вводимых данных требуемому
 * формату.
 */
public class InvalidDataException extends Exception {

    public InvalidDataException(String message) {
        super(message);
    }

}
