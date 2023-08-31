package ru.geekbrains.lesson_2.task_1;

import java.util.Scanner;

/**
 * Консольный пользовательский интерфейс, позволяющий выводит и запрашивать
 * информацию.
 */
public class ConsoleUserInterface {
    
    /**
     * Состояние программы.
     */
    private boolean isRunning;

    /**
     * Сканер.
     */
    private Scanner scanner;

    public ConsoleUserInterface() {
        isRunning = true;
        scanner = new Scanner(System.in);
    }

    /**
     * Выводит информацию пользователю.
     */
    private void print(String text) {
        System.out.print(text);
    }

    /**
     * Запрашивает информацию у пользователя.
     */
    private String request(String text) {
        print(text);
        return scanner.nextLine();
    }

    /**
     * Возвращает true, если строка является дробным десятичным числом, и
     * false, если не является.
     */
    private boolean isDecimalNum(String string) {
        try {
                Float.parseFloat(string);
            } catch (NumberFormatException numberFormatException) {
                return false;
            }
        return true;
    }

    /**
     * Открывает программу.
     */
    public void run() {
        while (isRunning) {
            String decimalNum = request("Введите дробное десятичное число. ");
            if (isDecimalNum(decimalNum)) {
                print(String.format("Введённое дробное десятичное " +
                                    "число - %f.\n",
                                    Float.parseFloat(decimalNum)));
                isRunning = false;
                return;
            }
            print("Введено не дробное десятичное число.\n");
        }
    }

}
