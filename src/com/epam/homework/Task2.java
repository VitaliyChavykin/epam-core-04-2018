package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    /**
     * Ввести N строк с консоли.
     * Упорядочить и вывести строки в порядке возрастания значений их длины.
     * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должны быть выведены N строк следующего вида:
     * (длина строки): строка наименьшей длины
     * (длина строки): строка большей длины
     * (длина строки): строка большей длины
     * ...
     * (длина строки): строка наибольшей длины
     * <p>
     * ----------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Тихо струится река серебристая
     * В царстве вечернем зеленой весны.
     * Солнце садится за горы лесистые.
     * Рог золотой выплывает луны.
     * <p>
     * Выходные данные:
     * (27): Рог золотой выплывает луны.
     * (30): Тихо струится река серебристая
     * (32): Солнце садится за горы лесистые.
     * (33): В царстве вечернем зеленой весны.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner( System.in );
        if ( scan.hasNextInt() ) {
            int number = Integer.valueOf( scan.nextLine() );
            List<String> myList = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                myList.add( scan.nextLine() );
            }
            myList.sort( Task2::compare );
            for (String cur : myList) {
                System.out.println( "(" + cur.length() + "): " + cur );
            }
        }
    }

    private static int compare(String s1, String s2) {
        if ( s1.length() == s2.length() )
            return s1.compareTo( s2 );
        return Integer.compare( s1.length(), s2.length() );
    }
}