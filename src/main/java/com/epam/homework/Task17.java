package com.epam.homework;

import java.util.Scanner;

public class Task17 {

    /**
     * Вычислить определитель матрицы
     * <a href="https://github.com/elefus/epam-core-04-2018/wiki/Представление-матриц">Представление матриц</a>
     * <p>
     * Формат входных данных:
     * N - целое число (0 < N < 10)
     * N ^ 2 целых чисел (Integer.MIN_VALUE < element < Integer.MAX_VALUE)
     * <p>
     * Формат выходных данных:
     * Целое число, соответствующее определителю матрицы.
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     * <p>
     * Входные данные:
     * 3
     * -2  1  2
     * 0 -1  0
     * 1 -2  3
     * <p>
     * Выходные данные:
     * 8
     * <p>
     * <p>
     * Входные данные:
     * 4
     * 6 4 0 1
     * 8 7 0 3
     * 1 3 0 9
     * 7 5 1 2
     * <p>
     * Выходные данные:
     * -65
     */
    public static void main(String[] args) {
        // TODO реализация
        System.out.println(findDeterminant(readMatrix()));
    }

    private static int[][] readMatrix(){
        try (Scanner scanner = new Scanner(System.in)) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            for (int row = 0; row < dimension; ++row) {
                for (int col = 0; col < dimension; ++col) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            return matrix;
        }
    }

    private static int findDeterminant(int[][] matrix) {
        int det = 0;
        int sign = 1;
        if (matrix.length == 1)
            return matrix[0][0];
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            for (int i = 0; i < matrix.length; i++) {
                det = det + sign * matrix[i][0] * findDeterminant(getMinor(matrix, i));
                sign *= (-1);
            }
        }
        return det;
    }

    private static int[][] getMinor(int[][] matrix, int row) {
        int shiftRow = 0;
        int[][] minor = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < minor.length; i++) {
            if (i == row) {
                shiftRow = 1;
            }
            System.arraycopy(matrix[i + shiftRow], 1, minor[i], 0, minor.length);
        }
        return minor;
    }
}