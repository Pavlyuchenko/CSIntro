import java.util.Arrays;

public class MatrixMult {
    public static void main(String[] args) {
        double[][] firstMatrix = {
                { 3, 4, 2 },
        };
        double[][] secondMatrix = {
                { 13, 9, 7, 15 },
                { 8, 7, 4, 6 },
                { 6, 4, 0, 3 }
        };

        System.out.println(Arrays.deepToString(multiplyMatrices(firstMatrix,
                secondMatrix)));
    }

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        int firstMatrixWidth = firstMatrix[0].length;
        int firstMatrixHeight = firstMatrix.length;
        int secondMatrixWidth = secondMatrix[0].length;
        int secondMatrixHeight = secondMatrix.length;

        double[][] resultMatrix = new double[firstMatrixHeight][secondMatrixWidth];

        if (firstMatrixWidth != secondMatrixHeight) {
            System.out.println("The width of the first matrix is not equal to the height of the second matrix.");
            return null;
        }

        for (int i = 0; i < firstMatrixHeight; i++) {
            double temp = 0;
            for (int j = 0; j < secondMatrixWidth; j++) {
                temp = 0;
                for (int k = 0; k < firstMatrixWidth; k++) {
                    temp += firstMatrix[i][k] * secondMatrix[k][j];
                }
                resultMatrix[i][j] = temp;
            }
        }
        return resultMatrix;
    }
}
