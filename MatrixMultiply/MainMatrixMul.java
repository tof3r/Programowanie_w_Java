import java.io.IOException;

public class MainMatrixMul {

    public static void main(String[] args) throws IOException {
	
	MatrixMultiplicate matrixMul = new MatrixMultiplicate();
	matrixMul.initializeMatrixDimensions();
	matrixMul.checkMultiplyConditionAndExecute();
	matrixMul.displayResults();
    }

}
