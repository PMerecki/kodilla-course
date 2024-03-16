package com.kodilla.patterns2.dodatek;

public class MatrixTranspose {
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 3, -2},
                {-7, 4, 8},
                {2, 7, 1},
                {9, 5, 3}
        };

        int[][] transposedMatrix = transposeMatrix(matrix);

        System.out.println("Original matrix:");
        printMatrix(matrix);

        System.out.println("\nTransposed matrix:");
        printMatrix(transposedMatrix);
    }
}

