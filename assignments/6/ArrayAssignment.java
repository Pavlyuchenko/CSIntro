import java.util.Arrays;

public class ArrayAssignment {

    public static void main(String[] args) {
        int[][] a = new int[8][8];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * a.length + j + 1 + i;
            }
        }
        System.out.println(Arrays.deepToString(a));
        diagonalPrint(a);
    }

    public static int allNumsWithin(int[] A, int k) {
        int min = A.length + 1;

        int i = 0; // Lower bound
        int j = 1; // Upper bound

        outerloop: do {
            int[] checkedPart = new int[j - i];

            for (int x = i; x < j; x++) {
                checkedPart[x - i] = A[x];
            }

            int[] valuesUsed = new int[k];
            for (int x = 0; x < checkedPart.length; x++) {
                if (checkedPart[x] < k) {
                    valuesUsed[checkedPart[x]] = 1;
                }
            }

            for (int x = 0; x < valuesUsed.length; x++) {
                if (valuesUsed[x] == 0) {
                    j++;
                    continue outerloop;
                }
            }

            boolean loop = true;
            while (loop) {
                valuesUsed = new int[k];
                for (int x = i + 1; x < checkedPart.length; x++) {
                    if (checkedPart[x] < k) {
                        valuesUsed[checkedPart[x]] = 1;
                    }
                }

                for (int x = 0; x < valuesUsed.length; x++) {
                    if (valuesUsed[x] == 0) {
                        loop = false;
                    }
                }

                if (loop)
                    i++;
            }

            min = Math.min(min, j - i);

            j++;
        } while (j <= A.length);

        if (min == A.length + 1) {
            return 0;
        } else {
            return min;
        }
    }

    public static void diagonalPrint(int[][] M) {
        if (M.length == 0) {
            return;
        }

        int vertical = 0;
        int horizontal = 0;
        while (vertical < M.length) {
            horizontal = 0;

            for (int i = vertical; i >= 0; i--) {
                if (i < 0 || horizontal >= M[0].length) {
                    break;
                }
                System.out.print(M[i][horizontal] + " ");
                horizontal++;
            }

            vertical++;
        }

        horizontal = 1;
        while (horizontal < M[0].length) {
            vertical = M.length - 1;
            int tempHorizontal = horizontal;

            for (int i = vertical; i >= 0; i--) {
                if (i < 0 || tempHorizontal >= M[0].length) {
                    break;
                }
                System.out.print(M[i][tempHorizontal] + " ");
                tempHorizontal++;
            }

            horizontal++;
        }
    }
}
