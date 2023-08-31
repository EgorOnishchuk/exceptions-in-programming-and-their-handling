package ru.geekbrains.lesson_2.task_3;

public class Main {
    
    public static void main(String[] args) throws Exception {
        try {
            int num1 = 90;
            int num2 = 3;
            System.out.println(num1 / num2);
            System.out.println(getSum(23, 234));
            int[] array = { 1, 2 };
            array[3] = 9;
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Обращение к несуществующему индексу " +
                               "массива невозможно.");
        } catch (Throwable errorOrException) {
            System.out.println("Произошла ошибка при выполнении программы.");
        }
    }

    public static int getSum(int num1, int num2) {
        return num1 + num2;
    }

}
