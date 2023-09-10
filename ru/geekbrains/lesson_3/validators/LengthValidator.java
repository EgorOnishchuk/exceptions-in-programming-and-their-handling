package ru.geekbrains.lesson_3.validators;

/**
 * Проверка соответствия длины требуемому значению.
 */
public class LengthValidator {

    /**
     * Коды ошибок.
     */
    private final int[] errorCodes = {-1, -2};

    /**
     * Требуемая длина.
     */
    private int length;

    public LengthValidator(int length) {
        this.length = length;
    }

    /**
     * Проверяет соответствие длины требуемому значению. Возвращает значение,
     * если оно соответствует длине, возвращает -1, если значение меньше
     * длины и возвращает -2, если значение больше длины.
     */
    public int validate(int value) {
        if (value == length) {
            return value;
        } else if (value < length) {
            return errorCodes[0];
        } else {
            return errorCodes[1];
        }
    }

}
