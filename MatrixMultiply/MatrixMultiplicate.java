import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixMultiplicate {
    
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String buffer;

    private int matrix1Row;
    private int matrix1Column;
    private int matrix2Row;
    private int matrix2Column;

    private int[][] Matrix1;
    private int[][] Matrix2;
    private int[][] result;

    public void initializeMatrixDimensions() throws IOException {
	System.out.println("Number of rows in Matrix 1 ");
	buffer = reader.readLine();

	matrix1Row = Integer.parseInt(buffer);

	System.out.println("Number of columns in Matrix 1 ");
	buffer = reader.readLine();

	matrix1Column = Integer.parseInt(buffer);

	System.out.println("Number of rows in Matrix 2 ");
	buffer = reader.readLine();

	matrix2Row = Integer.parseInt(buffer);

	System.out.println("Number of columns in Matrix 2 ");
	buffer = reader.readLine();

	matrix2Column = Integer.parseInt(buffer);
    }

    public void displayResults() {
	System.out.println("............................................");
	System.out.println("Matrix 1:");
	for (int i = 0; i < matrix1Row; i++) {
	    for (int j = 0; j < matrix1Column; j++) {
		System.out.print(Matrix1[i][j] + "\t");
	    }
	    System.out.println();
	}

	System.out.println("............................................");
	System.out.println("Matrix2:");
	for (int i = 0; i < matrix2Row; i++) {
	    for (int j = 0; j < matrix2Column; j++) {
		System.out.print(Matrix2[i][j] + "\t");
	    }
	    System.out.println();
	}
	System.out.println("............................................");
	System.out.println("Multiplication Completed!");
	System.out.println("............................................");
	System.out.println("Result");
	for (int i = 0; i < matrix1Row; i++) {
	    for (int j = 0; j < matrix2Column; j++) {
		System.out.print(result[i][j] + "\t");
	    }
	    System.out.println();
	}
	System.out.println("............................................");
    }

    private void fillMatrices() throws IOException {
	System.out
		.println("Insert values in Matrix1 (after each press enter):");
	for (int i = 0; i < matrix1Row; i++) {
	    for (int j = 0; j < matrix1Column; j++) {
		buffer = reader.readLine();
		System.out.println("Matrix1[" + i + "][" + j + "] = " + buffer);
		Matrix1[i][j] = Integer.parseInt(buffer);
	    }
	}

	System.out
		.println("Insert values in Matrix2 (after each press enter):");
	for (int i = 0; i < matrix2Row; i++) {
	    for (int j = 0; j < matrix2Column; j++) {
		buffer = reader.readLine();
		System.out.println("Matrix2[" + i + "][" + j + "] = " + buffer);
		Matrix2[i][j] = Integer.parseInt(buffer);
	    }
	}
    }

    private void multiplyMatrices() {
	int temp = 0;
	for (int i = 0; i < matrix1Row; i++) {
	    for (int j = 0; j < matrix2Column; j++) {
		for (int k = 0; k < matrix2Row; k++) {
		    temp = temp + Matrix1[i][k] * Matrix2[k][j];
		}
		result[i][j] = temp;
		temp = 0;
	    }
	}
    }

    private void initializeMatrixSize() {
	Matrix1 = new int[matrix1Row][matrix1Column];
	Matrix2 = new int[matrix2Row][matrix2Column];
	result = new int[matrix1Row][matrix2Column];
    }

    public void checkMultiplyConditionAndExecute() throws IOException {
	if (matrix1Column == matrix2Row) {
	    initializeMatrixSize();
	    fillMatrices();
	    multiplyMatrices();
	} else {
	    System.out.println("Multiplication couldn't be done!");
	    System.out
		    .println("Number of columns in a matrix1 should be equal to number of rows in matrix2 to perform multiplication.");
	}
    }
}
