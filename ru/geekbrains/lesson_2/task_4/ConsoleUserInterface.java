package ru.geekbrains.lesson_2.task_4;

import java.util.Scanner;

/**
 * Консольный пользовательский интерфейс, позволяющий запрашивать информацию.
 */
public class ConsoleUserInterface {

    /**
     * Сканер.
     */
    private Scanner scanner;

    public ConsoleUserInterface() {
        scanner = new Scanner(System.in);
    }

    /**
     * Запрашивает информацию у пользователя.
     */
    private String request(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

    /**
     * Открывает программу.
     */
    public void run() {
        if (request("Введите строку.").isEmpty()) {
            throw new RuntimeException("Введена пустая строка.");
        }
    }

}
