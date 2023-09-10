package ru.geekbrains.lesson_3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import ru.geekbrains.lesson_3.validators.BirthDateValidator;
import ru.geekbrains.lesson_3.validators.ExceptionValidator;
import ru.geekbrains.lesson_3.validators.LengthValidator;
import ru.geekbrains.lesson_3.validators.NameValidator;
import ru.geekbrains.lesson_3.validators.PhoneNumValidator;
import ru.geekbrains.lesson_3.validators.SexValidator;

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

    /**
     * Проверка количества данных.
     */
    private LengthValidator lengthValidator;

    /**
     * Проверки данных на действительность.
     */
    private ExceptionValidator[] validators;

    public ConsoleUserInterface() {
        isRunning = true;
        scanner = new Scanner(System.in);
        lengthValidator = new LengthValidator(6);
        validators = new ExceptionValidator[] {new NameValidator("Фамилия введена неверно"),
                                               new NameValidator("Имя введено неверно"),
                                               new NameValidator("Отчество введено неверно"),
                                               new SexValidator("Пол введён неверно"),
                                               new BirthDateValidator("Дата рождения введена неверно"),
                                               new PhoneNumValidator("Номер телефона введён неверно")};
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
     * Открывает программу.
     */
    public void run() {
        while(isRunning) {
            String action = request("Введите 'input' для ввода данных или " +
                                    "'exit' для выхода из программы. ");
            if (action.equals("input")) {
                String[] data = request("Введите фамилию, имя и отчество на " +
                                        "английском языке, пол в формате " +
                                        "'m' или 'f', дату рождения в " +
                                        "формате 'ДД.ММ.ГГГГ' и номер " +
                                        "телефона через пробел. ").split(" ");
                int dataNum = lengthValidator.validate(data.length);
                if (dataNum == -1) {
                    print("Введено недостаточно данных.\n");
                    continue;
                }
                if (dataNum == -2) {
                    print("Введено больше данных, чем требуется.\n");
                    continue;
                }
                try {
                    for (int i = 0; i < validators.length; i++) {
                        validators[i].validate(data[i]);
                    }
                } catch (InvalidDataException invalidDataException) {
                    print(String.format("%s.\n",
                                        invalidDataException.getMessage()));
                    continue;
                }
                try (FileWriter fileWriter = new FileWriter("C:\\Users\\User\\Desktop\\Материалы для ИТ\\Репозитории\\" +
                                                            "exceptions-in-programming-and-their-handling\\ru\\geekbrains\\" +
                                                            "lesson_3\\" + data[0] + ".txt", true)) {
                    fileWriter.append(String.format("%s %s %s %s %s %s\n",
                                                    data[0], data[1], data[2],
                                                    data[3], data[4], data[5]));
                } catch (IOException IOException) {
                    print(String.format("Произошла ошибка при работе с " +
                                        "файлами.\nПодробная информация\n%s",
                                        IOException.getStackTrace()));
                }
            } else if (action.equals("exit")) {
                isRunning = false;
            } else {
                print("Действие введено неверно.");
            }
        }
    }

}
