import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParalizedMatrixMult {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of rows of Matrix A: ");
        int rowsA=scanner.nextInt();

        System.out.println("Number of columns of Matrix A: ");
        int columnsA=scanner.nextInt();

        System.out.println("Number of rows of Matrix B: ");
        int rowsB=scanner.nextInt();

        System.out.println("Number of columns of Matrix B: ");
        int columnsB=scanner.nextInt();

        // generate matrix
        int[][] a = new int[rowsA][columnsA];
        int[][] b = new int[rowsB][columnsB];
        int[][] c = new int[rowsA][columnsB];

        generateMatrix(a, rowsA, columnsA);
        generateMatrix(b, rowsB, columnsB);

        // print Matrix A
        printMatrix(a, rowsA, columnsA);
        printMatrix(b, rowsB, columnsB);

        // matrix multiplication
        c = matrixMultiplication(a, b, c);

        // final matrix
        System.out.printf("\nMultiplied Matrix");
        printMatrix(c, rowsA, columnsB);
    }



    public static int[][] matrixMultiplication(int[][] a, int[][] b, int[][] c) throws InterruptedException {
        if(a[0].length != b.length) {
            throw new IllegalArgumentException("Number of rows from a must match number of columbs from b.");
        }

        ArrayList<MyThread> myThreads = new ArrayList<>();

        int cRows = c.length;
        int cColumns = c[0].length;
        int aColumns = a[0].length;
        int bColumns = b[0].length;

        for(int row = 0; row < cRows; row++){
            for(int column = 0; column < cColumns; column++){
                c[row][column] = 0;
            }
        }

        for(int row = 0; row < a.length; row++){
            for(int column = 0; column < bColumns; column++){
                for(int kRow = 0; kRow < aColumns; kRow++){
                    MyThread myThread = new MyThread(a, b, c, row, column, kRow);
                    myThread.start();
                    myThreads.add(myThread);
                }
            }
        }

        for(MyThread thread : myThreads){
            thread.join();
        }

        return c;

    }

    public static void printMatrix(int[][] matrix, int rows, int columns){
        for (int row = 0; row < rows; row ++) {
            System.out.println();
            for (int column = 0; column < columns; column++) {
                System.out.print(matrix[row][column] + " ");
            }
        }
        System.out.println();
    }

    public static void generateMatrix(int[][] matrix, int rows, int columns){
        Random random = new Random();
        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = random.nextInt(9) + 1;
            }
        }
    }
}
