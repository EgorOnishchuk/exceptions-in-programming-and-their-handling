package ru.geekbrains.lesson_2.task_2;

public class Main {
    
    public static void main(String[] args) {
        
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            /* Название "intArray" не гарантирует, что массив состоит из
            чисел - программный код может не скомпилироваться. */
            System.out.println("catchedRes1 = " + catchedRes1);
            /* Строка недостижима, так как её выполнение будет блокироваться
            вызываемыми на предыдущей строке исключениями. */
        } catch (ArithmeticException e) {
            /* Если длина массива может быть меньше 9, то необходимо
            обрабатывать ArrayIndexOutOfBoundsException. */
            System.out.println("Catching exception: " + e);
        }

    }

}
